package com.banco.msabono.dao;

import com.banco.msabono.negocio.Transaccion;

public interface ProcesarAbonoDaoInterface {
	
	public Transaccion abonar(String nrocuenta, Double monto) throws Exception;

}
