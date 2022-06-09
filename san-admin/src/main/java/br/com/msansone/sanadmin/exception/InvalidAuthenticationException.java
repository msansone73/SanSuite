package br.com.msansone.sanadmin.exception;

public class InvalidAuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidAuthenticationException(String message) {
		super(message);
	}

	public InvalidAuthenticationException() {
		super();
	}
	
}
