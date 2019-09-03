package com.banco.msrecarga.intregracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.msrecarga.negocio.Recarga;
import com.banco.msrecarga.negocio.RecargaNegocioInterface;
import com.banco.msrecarga.negocio.Transaccion;

@RestController
public class RecargaRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RecargaNegocioInterface recargaNegocio;

	@PostMapping(path = "/recarga")
	/*
	 * public Transaccion procesarRecarga(@RequestBody Recarga recarga) throws
	 * Exception {
	 * 
	 * Transaccion tx = new Transaccion(); tx.setCodigo("0000");
	 * tx.setDescripcion("Proceso conforme");
	 * 
	 * return recargaNegocio.procesarRecarga(recarga); }
	 */
	public Transaccion procesarRecarga(@RequestBody Recarga recarga) throws Exception {

		Transaccion trx = new Transaccion();
		trx = recargaNegocio.procesarRecarga(recarga);
		logger.info("{}", trx);
		return trx;
	}
}
