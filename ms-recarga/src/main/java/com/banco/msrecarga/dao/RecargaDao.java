package com.banco.msrecarga.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.banco.msrecarga.negocio.Recarga;
import com.banco.msrecarga.negocio.Transaccion;
import com.banco.msrecarga.util.PropertiesExternal;

@RestController
public class RecargaDao implements RecargaDaoInterface {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PropertiesExternal properties;

	@Override
	public Transaccion procesarRecarga(Recarga recarga) throws Exception {
		Transaccion tx = new Transaccion();
		PreparedStatement pstmt = null;
		Conexion con = null;
		int codigoExito = properties.pCODIGO_IDENTIFICADRO_EXITO;
		String SQL = "update esq_banco.TBL_PRODUCTO set saldo = (select saldo from esq_banco.TBL_PRODUCTO tp where tp.NRO = ?)+?  where NRO = ?";
		
		try {
			con = new Conexion();
			con.getConnection().setAutoCommit(false);
			pstmt = con.getConnection().prepareStatement(SQL);
			pstmt.setString(1, recarga.getNumero());
			pstmt.setDouble(2, recarga.getMonto());
			pstmt.setString(3, recarga.getNumero());
			int codigoRespuesta = pstmt.executeUpdate();

			if (codigoRespuesta == codigoExito) {				
				logger.info("codigoRespuesta= " + properties.pCODIGO_RESPUESTA_EXITO);
				logger.info("mensajeRespuesta= " + properties.pMENSAJE_RESPUESTA_EXITO);
				tx.setCodigo(properties.pCODIGO_RESPUESTA_EXITO);
				tx.setDescripcion(properties.pMENSAJE_RESPUESTA_EXITO);				
				con.getConnection().commit();
				
			} else {			
				logger.info("codigoRespuesta= " + properties.pCODIGO_ERROR_RECARGO);
				logger.info("mensajeRespuesta= " + properties.pMENSAJE_ERROR_RECARGO);
				tx.setCodigo(properties.pCODIGO_ERROR_RECARGO);
				tx.setDescripcion(properties.pMENSAJE_ERROR_RECARGO);
			}

		} catch (SQLException sqle) {
			throw new Exception(sqle.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				con.closeResources(con.getConnection(), null, null, null, pstmt);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		return tx;
	}

}
