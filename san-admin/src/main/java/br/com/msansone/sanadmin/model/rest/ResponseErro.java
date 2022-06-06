package br.com.msansone.sanadmin.model.rest;

public class ResponseErro {
	
	
	
	public ResponseErro(String mensage) {
		super();
		this.mensage = mensage;
	}

	private String mensage;

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
	
	

}
