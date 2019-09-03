package com.banco.msgestorpago.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.msgestorpago.clientservices.Transaccion;
import com.banco.msgestorpago.process.ProcesarCargoAbonoInterface;

@RestController
public class PagoAbonoRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProcesarCargoAbonoInterface procesarCargoAbono;

	@PostMapping(path = "/procesarpago")
	public Transaccion procesarCargoAbono(@RequestBody Pago cuentas) {

		Transaccion tx = new Transaccion();
		tx = procesarCargoAbono.procesarCargoAbono(cuentas.getAbono(), cuentas.getCargo(), cuentas.getDni(),
				cuentas.getCelular());
		logger.info("{}", tx);
		return tx;
	}

}
