package com.aluracursos.hub_challenge.infra.exceptions;

public class TopicoNoEncontradoException extends RuntimeException {
    public TopicoNoEncontradoException(Long id) {
        super("Tópico con el ID " + id + " no encontrado");
    }
}
