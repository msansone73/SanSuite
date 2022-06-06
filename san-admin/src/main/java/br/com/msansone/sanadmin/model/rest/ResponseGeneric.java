package br.com.msansone.sanadmin.model.rest;


public class ResponseGeneric{	
	
	public ResponseGeneric(Object response, ResponseErro responseerro) {
		super();
		this.response = response;
		this.responseerro = responseerro;
	}
	
	private Object response;
	private ResponseErro responseerro;
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public ResponseErro getResponseerro() {
		return responseerro;
	}
	public void setResponseerro(ResponseErro responseerro) {
		this.responseerro = responseerro;
	}

	
	
}
