package com.banco.mscargo.integracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.mscargo.negocio.Cuenta;
import com.banco.mscargo.negocio.ProcesarCargoNegocioInterface;
import com.banco.mscargo.negocio.Transaccion;

@RestController
public class ProcesarCargoRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProcesarCargoNegocioInterface procesarCargoNegocio;

	@PostMapping(path = "/cargar")
	public Transaccion cargar(@RequestBody Cuenta cuenta) throws Exception {
		String nrocuenta = cuenta.getNrocuenta();
		Double monto = cuenta.getMonto();

		Transaccion trx = new Transaccion();
		trx = procesarCargoNegocio.cargo(nrocuenta, monto);
		logger.info("{}", trx);

		return trx;
	}

}
