package com.banco.msabono.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.msabono.dao.ProcesarAbonoDaoInterface;

@Service
public class ProcesarAbonoNegocio implements ProcesarAbonoNegocioInterface {
	
	@Autowired
	private ProcesarAbonoDaoInterface procesarAbonoDao;

	@Override
	public Transaccion abonar(String nrocuenta, Double monto)  throws Exception {
		// TODO Auto-generated method stub
		return procesarAbonoDao.abonar(nrocuenta, monto);
	}

}
