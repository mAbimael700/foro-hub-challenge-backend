package com.aluracursos.hub_challenge.domain.topico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosRegistroTopico(
        @NotNull Long idUsuario,
        @NotNull Long idCurso,
        @NotNull @Size(max = 255, min = 2) String titulo,
        @NotNull @Size(max = 1000, min = 2) String mensaje,
        @NotNull Estado estado
) {
}
