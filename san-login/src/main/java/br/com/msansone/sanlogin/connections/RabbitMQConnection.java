package br.com.msansone.sanlogin.connections;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import br.com.msansone.sanlogin.constants.RabbitMQConstats;


@Component
public class RabbitMQConnection {
	private static final String NOME_EXCHANGE = "amq.direct";
	
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin=amqpAdmin;
	}

	
	private Queue fila(String nomeFila) {
		return new Queue(nomeFila, true, false, false);
	}
	
	private DirectExchange trocaDireita() {
		return new DirectExchange(NOME_EXCHANGE);
	}
	
	private Binding relacionamento(Queue fila, DirectExchange troca) {
		return new Binding(fila.getName(), 
				Binding.DestinationType.QUEUE, 
				troca.getName(), 
				fila.getName(), 
				null);
	}
	
	@PostConstruct
	private void adiciona() {
		Queue filaLog=this.fila(RabbitMQConstats.FILA_LOG);
		
		DirectExchange troca = this.trocaDireita();

		Binding ligacao = this.relacionamento(filaLog, troca);
		
		amqpAdmin.declareQueue(filaLog);
		amqpAdmin.declareExchange(troca);
		amqpAdmin.declareBinding(ligacao);
		
	}

}

