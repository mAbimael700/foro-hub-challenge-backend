package com.aluracursos.hub_challenge.domain.curso;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosRegistroCurso(
        @NotNull @Size(max = 255, min = 2) String nombre,
        @NotNull CategoriaCurso categoria
) {
}
