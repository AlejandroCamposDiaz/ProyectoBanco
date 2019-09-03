package com.banco.msbuspago.clientservice;

public class Pago {

	private Cuenta cargo;
	private Cuenta abono;
	private String dni;
	private String celular;

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Cuenta getCargo() {
		return cargo;
	}

	public void setCargo(Cuenta cargo) {
		this.cargo = cargo;
	}

	public Cuenta getAbono() {
		return abono;
	}

	public void setAbono(Cuenta abono) {
		this.abono = abono;
	}

}
