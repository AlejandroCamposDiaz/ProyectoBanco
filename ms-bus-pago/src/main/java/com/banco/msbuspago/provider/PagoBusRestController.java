package com.banco.msbuspago.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.msbuspago.clientservice.BusPagoInterface;
import com.banco.msbuspago.clientservice.Pago;
import com.banco.msbuspago.clientservice.Transaccion;

@RestController
public class PagoBusRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BusPagoInterface busPago;

	@PostMapping(path = "/busprocesarpago")
	public Transaccion procesarCargoAbono(@RequestBody Pago cuentas) {
		Transaccion tx = new Transaccion();
		tx = busPago.procesarCargoAbono(cuentas);
		logger.info("{}", tx);
		return tx;
	}
}
