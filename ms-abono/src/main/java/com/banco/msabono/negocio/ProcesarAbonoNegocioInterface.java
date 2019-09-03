package com.banco.msabono.negocio;

public interface ProcesarAbonoNegocioInterface {
	public Transaccion abonar(String nrocuenta, Double monto)  throws Exception;

}
