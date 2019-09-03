package com.banco.mscargo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.mscargo.dao.ProcesarCargoDaoInterface;

@Service
public class ProcesarCargoNegocio implements ProcesarCargoNegocioInterface{
	
	@Autowired
	private ProcesarCargoDaoInterface ProcesarCargoDao;

	@Override
	public Transaccion cargo(String nrocuenta, Double monto) throws Exception {
		// TODO Auto-generated method stub
		return ProcesarCargoDao.cargo(nrocuenta, monto);
	}

}
