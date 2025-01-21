package com.aluracursos.hub_challenge.domain.respuesta;

import com.aluracursos.hub_challenge.domain.topico.Estado;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosRegistroRespuesta(
        @NotNull Long idUsuario,
        @NotNull Long idTopico,
        @NotNull @Size(max = 255, min = 2) String titulo,
        @NotNull @Size(max = 1000, min = 2) String solucion
) {
}
