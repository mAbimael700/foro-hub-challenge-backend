package com.aluracursos.hub_challenge.domain.topico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosActualizarTopico(
        @NotNull Long id,
        @Size(max = 255, min = 2) String titulo,
        @Size(max = 1000, min = 2) String mensaje,
        Estado estado
) {
}
