package br.com.msansone.sanadmin.model.rest;


public class ResponseGeneric{	
		
	public ResponseGeneric(Object response, Exception erro) {
		super();
		this.response = response;
		this.erro = erro;
	}
	
	private Object response;
	private Exception erro;
	
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public String getErroMessage() {
		return erro==null?"": erro.getMessage();
	}
	
	
}
