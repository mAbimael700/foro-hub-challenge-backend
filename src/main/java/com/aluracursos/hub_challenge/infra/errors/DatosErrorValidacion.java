package com.aluracursos.hub_challenge.infra.errors;

import java.util.List;

public record DatosErrorValidacion(
        String mensaje,
        Integer status,
        List<String> errores
) {
}
