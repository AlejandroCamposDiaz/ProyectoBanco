package com.banco.msabono.integracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.msabono.negocio.Cuenta;
import com.banco.msabono.negocio.ProcesarAbonoNegocioInterface;
import com.banco.msabono.negocio.Transaccion;

@RestController
public class ProcesarAbonoRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProcesarAbonoNegocioInterface procesarAbonoNegocio;

	@PostMapping(path = "/abonar")
	public Transaccion abonar(@RequestBody Cuenta cuenta) throws Exception {
		String nrocuenta = cuenta.getNrocuenta();
		Double monto = cuenta.getMonto();

		Transaccion trx = new Transaccion();
		trx = procesarAbonoNegocio.abonar(nrocuenta, monto);
		logger.info("{}", trx);

		return trx;

	}

}
