package com.aluracursos.hub_challenge.infra.errors;

public record DatosErrorException(
        String error,
        Integer status
) {
}
