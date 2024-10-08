package org.mateus.ConsultaTabelaFipe.handler;

public interface IResponseHandler {
    public <T> T consumeResponse(String json, Class<T> tclass);
}
