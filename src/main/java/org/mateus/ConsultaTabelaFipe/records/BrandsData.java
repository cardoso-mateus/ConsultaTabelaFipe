package org.mateus.ConsultaTabelaFipe.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrandsData(
        @JsonAlias("") Integer code,
        @JsonAlias("") String brand
) {}
