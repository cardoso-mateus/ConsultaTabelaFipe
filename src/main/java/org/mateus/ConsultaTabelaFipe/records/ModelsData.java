package org.mateus.ConsultaTabelaFipe.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelsData(
        @JsonAlias("modelos") List<String>
) {}
