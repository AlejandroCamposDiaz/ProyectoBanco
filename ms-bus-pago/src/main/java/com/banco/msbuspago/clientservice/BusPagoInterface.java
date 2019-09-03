package com.banco.msbuspago.clientservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name="ms-pago")
@RibbonClient(name="ms-pago")
public interface BusPagoInterface {
	
	@PostMapping(path = "/mspago/procesarpago")
	public Transaccion procesarCargoAbono(@RequestBody Pago cuentas);
	

}
