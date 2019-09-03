package com.banco.msgestorpago.clientservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="ms-cargo")
@RibbonClient(name="ms-cargo")
public interface CargoInterface {
	
	@PostMapping(path = "/mscargo/cargar")
	public Transaccion cargar(@RequestBody Cuenta cuenta);

}
