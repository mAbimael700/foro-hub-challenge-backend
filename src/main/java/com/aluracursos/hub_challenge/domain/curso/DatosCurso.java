package com.aluracursos.hub_challenge.domain.curso;

public record DatosCurso(
        Long id,
        String nombre,
        CategoriaCurso categoria
) {
    public DatosCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
