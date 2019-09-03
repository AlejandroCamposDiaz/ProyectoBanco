package com.banco.msgestorpago.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.msgestorpago.util.PropertiesExternal;
import com.banco.msgestorpago.clientservices.AbonoInterface;
import com.banco.msgestorpago.clientservices.CargoInterface;
import com.banco.msgestorpago.clientservices.Cuenta;
import com.banco.msgestorpago.clientservices.Recarga;
import com.banco.msgestorpago.clientservices.RecargaInterface;
import com.banco.msgestorpago.clientservices.Transaccion;

@Service
public class ProcesarCargoAbono implements ProcesarCargoAbonoInterface {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PropertiesExternal properties;

	@Autowired
	private AbonoInterface abono;

	@Autowired
	private CargoInterface cargo;

	@Autowired
	private RecargaInterface recarga;

	@Override
	public Transaccion procesarCargoAbono(Cuenta abonar, Cuenta cargar, String dni, String celular) {

		Transaccion salida = new Transaccion();
		Transaccion txcargo = cargo.cargar(cargar);

		if (txcargo.getCodigo().equals(properties.pCODIGO_RESPUESTA_EXITO)) {
			logger.info("codigoRespuesta= " + properties.pCODIGO_EXITO_CARGO);
			logger.info("mensajeRespuesta= " + properties.pMENSAJE_EXITO_CARGO);
			salida.setCodigo(properties.pCODIGO_RESPUESTA_EXITO);
			salida.setDescripcion(properties.pMENSAJE_RESPUESTA_EXITO);

			Transaccion txabono = abono.abonar(abonar);

			if (txabono.getCodigo().equals(properties.pCODIGO_RESPUESTA_EXITO)) {
				logger.info("codigoRespuesta= " + properties.pCODIGO_EXITO_ABONO);
				logger.info("mensajeRespuesta= " + properties.pMENSAJE_EXITO_ABONO);
				salida.setCodigo(properties.pCODIGO_EXITO_ABONO);
				salida.setDescripcion(properties.pMENSAJE_EXITO_ABONO);

				Recarga obj = new Recarga();
				obj.setNumero(celular);
				obj.setDni(dni);
				obj.setMonto(cargar.getMonto());
				logger.info("MONTO A RECARGAR= " + cargar.getMonto());
				Transaccion txrecarga = recarga.procesarRecarga(obj);

				if (txrecarga.getCodigo().equals(properties.pCODIGO_RESPUESTA_EXITO)) {
					logger.info("codigoRespuesta= " + properties.pCODIGO_EXITO_RECARGO);
					logger.info("mensajeRespuesta= " + properties.pMENSAJE_EXITO_RECARGO);
					salida.setCodigo(properties.pCODIGO_RESPUESTA_EXITO);
					salida.setDescripcion(properties.pMENSAJE_RESPUESTA_EXITO);
					logger.info("codigoRespuesta= " + properties.pCODIGO_RESPUESTA_EXITO);
					logger.info("mensajeRespuesta= " + properties.pMENSAJE_RESPUESTA_EXITO);

				} else {
					logger.info("codigoRespuesta= " + properties.pCODIGO_ERROR_RECARGO);
					logger.info("mensajeRespuesta= " + properties.pMENSAJE_ERROR_RECARGO);
					salida.setCodigo(properties.pCODIGO_RESPUESTA_ERROR);
					salida.setDescripcion(properties.pMENSAJE_RESPUESTA_ERROR);
				}

			} else {
				logger.info("codigoRespuesta= " + properties.pCODIGO_ERROR_ABONO);
				logger.info("mensajeRespuesta= " + properties.pMENSAJE_ERROR_ABONO);
				salida.setCodigo(properties.pCODIGO_RESPUESTA_ERROR);
				salida.setDescripcion(properties.pMENSAJE_RESPUESTA_ERROR);
			}
		} else {
			logger.info("codigoRespuesta= " + properties.pCODIGO_ERROR_CARGO);
			logger.info("mensajeRespuesta= " + properties.pMENSAJE_ERROR_CARGO);
			salida.setCodigo(properties.pCODIGO_RESPUESTA_ERROR);
			salida.setDescripcion(properties.pMENSAJE_RESPUESTA_ERROR);
		}
		return salida;
	}
}
