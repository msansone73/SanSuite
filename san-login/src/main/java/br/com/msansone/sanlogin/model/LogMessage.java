package br.com.msansone.sanlogin.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogMessage implements Serializable {

	private static final long serialVersionUID = -9207492680443682238L;


	public LogMessage(Long applicationId, String message) {
		super();
		this.applicationId = applicationId;
		this.message = message;
	}
	
	private Date data = new Date();
	private Long applicationId;
	private String message;
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		return sdf.format(data) + ":  App: " + applicationId + " -  message=" + message;
	}
	
	
	
	
}
