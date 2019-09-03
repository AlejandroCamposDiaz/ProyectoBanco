package com.banco.mscargo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banco.mscargo.negocio.Transaccion;
import com.banco.mscargo.util.PropertiesExternal;

@Repository
public class ProcesarCargoDao implements ProcesarCargoDaoInterface {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PropertiesExternal properties;

	@Override
	public Transaccion cargo(String nrocuenta, Double monto) throws Exception {
		Transaccion tx = new Transaccion();
		PreparedStatement pstmt = null;
		Conexion con = null;
		int codigoExito = properties.pCODIGO_IDENTIFICADRO_EXITO;
		String SQL = "update esq_banco.TBL_CUENTA set saldo = (select saldo from esq_banco.TBL_CUENTA tc where tc.NROCUENTA = ?)-?  where NROCUENTA = ?";

		try {
			con = new Conexion();
			con.getConnection().setAutoCommit(false);
			pstmt = con.getConnection().prepareStatement(SQL);
			pstmt.setString(1, nrocuenta);
			pstmt.setDouble(2, monto);
			pstmt.setString(3, nrocuenta);

			int codigoRespuesta = pstmt.executeUpdate();

			if (codigoRespuesta == codigoExito) {
				logger.info("codigoRespuesta= " + properties.pCODIGO_RESPUESTA_EXITO);
				logger.info("mensajeRespuesta= " + properties.pMENSAJE_RESPUESTA_EXITO);
				tx.setCodigo(properties.pCODIGO_RESPUESTA_EXITO);
				tx.setDescripcion(properties.pMENSAJE_RESPUESTA_EXITO);
				con.getConnection().commit();
				
			} else {
				logger.info("codigoRespuesta= " + properties.pCODIGO_ERROR_CARGO);
				logger.info("mensajeRespuesta= " + properties.pMENSAJE_ERROR_CARGO);
				tx.setCodigo(properties.pCODIGO_ERROR_CARGO);
				tx.setDescripcion(properties.pMENSAJE_ERROR_CARGO);
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
