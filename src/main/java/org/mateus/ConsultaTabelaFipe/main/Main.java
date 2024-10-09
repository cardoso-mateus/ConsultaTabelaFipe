package org.mateus.ConsultaTabelaFipe.main;

import org.mateus.ConsultaTabelaFipe.consumer.APIConsumer;
import org.mateus.ConsultaTabelaFipe.handler.ResponseHandler;
import org.mateus.ConsultaTabelaFipe.records.BrandsData;
import org.mateus.ConsultaTabelaFipe.records.ModelsData;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final String SITE = "https://parallelum.com.br/fipe/api/v1/";
    private final String CARS = "carros/marcas/";
    private final String MOTORCYLES = "motos/marcas/";
    private final String TRUCKS = "caminhoes/marcas/";
    private APIConsumer consumer = new APIConsumer();
    private ResponseHandler handler = new ResponseHandler();
    private Scanner input = new Scanner(System.in);
    public void start() {
        String url = null;
        url = selectVehicleType(url);

        System.out.println("\nEscolha uma marca de acordo com o código ao lado");
        int choice = input.nextInt();
        input.nextLine();

        url = url + choice + "/modelos/";

        String json = consumer.APIConsume(url);

        List<ModelsData> brandsData = List.of(handler.consumeResponse(json, ModelsData[].class));
        brandsData.forEach(System.out::println);
    }

    private String selectVehicleType(String url) {
        System.out.println("""
                
                Digite 1 para buscar carros.
                Digite 2 para buscar motos.
                Digite 3 para buscar caminhões.
                """);

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                url = SITE+ CARS;
                break;
            case 2:
                url = SITE+MOTORCYLES;
                break;
            case 3:
                url = SITE+TRUCKS;
                break;
            default:
                System.out.println("Opção inválida!");
        }

        String json = consumer.APIConsume(url);

        List<BrandsData> brandsData = List.of(handler.consumeResponse(json, BrandsData[].class));
        brandsData.forEach(System.out::println);

        return url;
    }
}
