package org.mateus.ConsultaTabelaFipe.main;

import org.mateus.ConsultaTabelaFipe.consumer.APIConsumer;
import org.mateus.ConsultaTabelaFipe.handler.ResponseHandler;
import org.mateus.ConsultaTabelaFipe.records.BrandsData;
import org.mateus.ConsultaTabelaFipe.records.ModelsSetData;
import org.mateus.ConsultaTabelaFipe.records.VehicleData;
import org.mateus.ConsultaTabelaFipe.records.YearsData;

import java.util.ArrayList;
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
        url = selectVehicleBrand(url);
        url = selectModel(url);
        selectModelYear(url);
    }

    private void selectModelYear(String url) {
        System.out.println("\nEscolha o ano do modelo de acordo com o código ao lado");
        String choice = input.nextLine();

        url = url + choice;

        String json = consumer.APIConsume(url);
        VehicleData vehicleData = handler.consumeResponse(json, VehicleData.class);
        System.out.println(vehicleData);
    }

    private String selectModel(String url) {
        System.out.println("\nEscolha um modelo de acordo com o código ao lado");
        int choice = input.nextInt();
        input.nextLine();

        url = url + choice + "/anos/";

        String json = consumer.APIConsume(url);

        List<YearsData> yearsData = List.of(handler.consumeResponse(json, YearsData[].class));
        yearsData.forEach(System.out::println);

        return url;
    }

    private String selectVehicleBrand(String url) {
        System.out.println("\nEscolha uma marca de acordo com o código ao lado");
            int choice = input.nextInt();
        input.nextLine();

        url = url + choice + "/modelos/";

        String json = consumer.APIConsume(url);
        ModelsSetData modelsSetData = handler.consumeResponse(json, ModelsSetData.class);

        List<ModelsSetData> modelsSetDataList = new ArrayList<>();
        modelsSetDataList.add(modelsSetData);
        modelsSetDataList.stream().flatMap(m -> m.models().stream()).forEach(System.out::println);

        return url;
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
