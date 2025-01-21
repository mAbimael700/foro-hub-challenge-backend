package com.aluracursos.hub_challenge.domain.usuario;

public record DatosAutor(
        Long id,
        String nombre,
        String correo_electronico
) {
    public DatosAutor(Usuario autor) {
        this(
                autor.getId(),
                autor.getNombre(),
                autor.getCorreoElectronico()
        );
    }
}
