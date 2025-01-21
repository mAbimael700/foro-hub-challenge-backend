package com.aluracursos.hub_challenge.domain.topico;

import com.aluracursos.hub_challenge.domain.curso.DatosCurso;
import com.aluracursos.hub_challenge.domain.respuesta.DatosRespuesta;
import com.aluracursos.hub_challenge.domain.usuario.DatosAutor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public record DatosTopico(
        Long id,
        String titulo,
        String mensaje,
        Estado estado,
        DatosAutor autor,
        LocalDateTime fechaCreacion,
        DatosCurso curso,
        List<DatosRespuesta> respuestas
) {
    public DatosTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstado(),
                new DatosAutor(topico.getAutor()),
                topico.getFechaCreacion(),
                new DatosCurso(topico.getCurso()),
                topico.getRespuestas()
                        .stream()
                        .map(DatosRespuesta::new).toList()
        );
    }
}
