package es.logixs.emisor;

import es.logixs.Persona;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmisorApplication implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;

	public EmisorApplication(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmisorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int i=0;
		while (i<5) {

			Thread.sleep(1000);
			i++;
			System.out.println("enviando un mensaje");
		    rabbitTemplate.convertAndSend("spring-boot-exchange","miruta",new Persona("pepe",i));
		}

	}
}
