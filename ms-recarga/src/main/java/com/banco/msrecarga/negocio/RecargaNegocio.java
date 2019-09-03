package com.banco.msrecarga.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.msrecarga.dao.RecargaDaoInterface;

@Service
public class RecargaNegocio implements RecargaNegocioInterface {
	
	@Autowired
	private RecargaDaoInterface recargaDao;

	@Override
	public Transaccion procesarRecarga(Recarga recarga) throws Exception {
		// TODO Auto-generated method stub
		return recargaDao.procesarRecarga(recarga);
	}

}
