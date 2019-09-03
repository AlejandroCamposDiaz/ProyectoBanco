package com.banco.msgestorpago.clientservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="ms-abono")
@RibbonClient(name="ms-abono")
public interface AbonoInterface {
	@PostMapping(path = "/msabono/abonar")
	public Transaccion abonar(@RequestBody Cuenta cuenta);

}
