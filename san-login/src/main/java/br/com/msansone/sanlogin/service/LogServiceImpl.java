package br.com.msansone.sanlogin.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msansone.sanlogin.constants.RabbitMQConstats;
import br.com.msansone.sanlogin.model.LogMessage;

@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void addLog(LogMessage log) {

		this.rabbitTemplate.convertAndSend(RabbitMQConstats.FILA_LOG,log);
		
	}

	@Override
	public void gravaLogText(LogMessage log) throws IOException {
        // Assign the content of the file
        String text  = log.toString()+"\n";
 
        // Define the file name of the file
        Path fileName = Path.of("./AppLog.txt");
 
        // Write into the file
        Files.writeString(fileName, text);
 
        // Read the content of the file
        String file_content = Files.readString(fileName);
 
        // Print the content inside the file
        System.out.println(file_content);
		
	}

}
