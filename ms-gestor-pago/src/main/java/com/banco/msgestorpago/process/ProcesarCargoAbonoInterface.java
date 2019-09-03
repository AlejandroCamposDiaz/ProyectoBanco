package com.banco.msgestorpago.process;

import com.banco.msgestorpago.clientservices.Cuenta;
import com.banco.msgestorpago.clientservices.Transaccion;

public interface ProcesarCargoAbonoInterface {

	public Transaccion procesarCargoAbono(Cuenta abonar, Cuenta cargar, String dni, String celular);

}
