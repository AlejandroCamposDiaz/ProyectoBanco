package com.banco.mscargo.dao;

import com.banco.mscargo.negocio.Transaccion;

public interface ProcesarCargoDaoInterface {
	
	public Transaccion cargo(String nrocuenta, Double monto) throws Exception;

}
