package com.banco.msgestorpago.clientservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name="ms-recarga")
@RibbonClient(name="ms-recarga")
public interface RecargaInterface {
	
	@PostMapping(path = "/msrecarga/recarga")
	public Transaccion procesarRecarga(@RequestBody Recarga recarga);

}
