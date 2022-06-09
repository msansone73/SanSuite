package br.com.msansone.sanadmin.model.rest;

public class LoginRequest {
	
	public LoginRequest(Long applicationId, String email, String password) {
		super();
		this.applicationId = applicationId;
		this.email = email;
		this.password = password;
	}
	
	private Long applicationId;
	private String email;
	private String password;
	
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
