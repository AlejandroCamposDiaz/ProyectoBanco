package com.banco.mscargo.negocio;

public interface ProcesarCargoNegocioInterface {
	
	public Transaccion cargo(String nrocuenta, Double monto) throws Exception;

}
