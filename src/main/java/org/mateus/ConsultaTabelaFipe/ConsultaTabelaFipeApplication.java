package org.mateus.ConsultaTabelaFipe;

import org.mateus.ConsultaTabelaFipe.consumer.APIConsumer;
import org.mateus.ConsultaTabelaFipe.handler.ResponseHandler;
import org.mateus.ConsultaTabelaFipe.records.BrandsData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ConsultaTabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaTabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		APIConsumer consumer = new APIConsumer();
		ResponseHandler handler = new ResponseHandler();
		String json = consumer.APIConsume("https://parallelum.com.br/fipe/api/v1/carros/marcas");
		List<BrandsData> brandsData = handler.consumeResponse(json, List.class);
    	System.out.println(brandsData);
	}
}
