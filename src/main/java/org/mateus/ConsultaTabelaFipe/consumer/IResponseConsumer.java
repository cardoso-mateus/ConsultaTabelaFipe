package org.mateus.ConsultaTabelaFipe.consumer;

public interface IResponseConsumer {
    public <T> T consumeResponse(String json, Class<T> tclass);
}
