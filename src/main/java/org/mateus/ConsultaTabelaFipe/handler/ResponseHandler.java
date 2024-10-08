package org.mateus.ConsultaTabelaFipe.handler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseHandler implements IResponseHandler {
    @Override
    public <T> T consumeResponse(String json, Class<T> tclass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, tclass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
