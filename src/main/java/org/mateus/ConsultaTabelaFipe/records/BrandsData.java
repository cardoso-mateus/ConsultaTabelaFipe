package org.mateus.ConsultaTabelaFipe.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrandsData(
        @JsonAlias("codigo") String code,
        @JsonAlias("nome") String brand
) {}
