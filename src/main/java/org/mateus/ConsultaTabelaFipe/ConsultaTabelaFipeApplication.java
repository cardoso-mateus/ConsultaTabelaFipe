package org.mateus.ConsultaTabelaFipe;

import org.mateus.ConsultaTabelaFipe.consumer.APIConsumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaTabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaTabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		APIConsumer consumer = new APIConsumer();
		consumer.APIConsume("https://parallelum.com.br/fipe/api/v1/carros/marcas");
	}
}
