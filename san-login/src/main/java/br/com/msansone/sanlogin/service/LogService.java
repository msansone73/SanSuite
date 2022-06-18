package br.com.msansone.sanlogin.service;

import java.io.IOException;

import br.com.msansone.sanlogin.model.LogMessage;

public interface LogService {

	void addLog(LogMessage log);
	
	void gravaLogText(LogMessage log) throws IOException;

}
