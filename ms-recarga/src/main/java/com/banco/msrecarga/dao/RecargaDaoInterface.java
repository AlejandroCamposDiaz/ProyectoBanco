package com.banco.msrecarga.dao;

import com.banco.msrecarga.negocio.Recarga;
import com.banco.msrecarga.negocio.Transaccion;

public interface RecargaDaoInterface {
	public Transaccion procesarRecarga(Recarga recarga) throws Exception;

}
