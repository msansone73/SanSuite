package br.com.msansone.sanlogin.consumer;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.msansone.sanlogin.constants.RabbitMQConstats;
import br.com.msansone.sanlogin.model.LogMessage;
import br.com.msansone.sanlogin.service.LogService;

@Component
public class LogConsumer {
	
	@Autowired
	private LogService logService;
	
	@RabbitListener(queues = RabbitMQConstats.FILA_LOG)
	private void consumidor(LogMessage log) {
	
		try {
			logService.gravaLogText(log);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro: "+ e.getMessage());
			System.out.println("Log: "+log.toString());
		}
	}

}
