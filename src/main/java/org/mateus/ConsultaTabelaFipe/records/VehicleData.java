package org.mateus.ConsultaTabelaFipe.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleData(
        @JsonAlias("Valor") String price,
        @JsonAlias("Marca") String brand,
        @JsonAlias("Modelo") String model,
        @JsonAlias("AnoModelo") int modelYear,
        @JsonAlias("Combustivel") String fuel,
        @JsonAlias("CodigoFipe") String FIPECode,
        @JsonAlias("MesReferencia") String monthOfReference
) {}
