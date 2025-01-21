package com.aluracursos.hub_challenge.domain.respuesta;

import com.aluracursos.hub_challenge.domain.curso.DatosCurso;
import com.aluracursos.hub_challenge.domain.topico.DatosTopico;
import com.aluracursos.hub_challenge.domain.topico.Estado;
import com.aluracursos.hub_challenge.domain.usuario.DatosAutor;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRespuesta(
        Long id,
        String mensaje,
        String solucion,
        DatosAutor autor,
        LocalDateTime fechaCreacion,
        DatosTopico topico

) {
    public DatosRespuesta(Respuesta r) {
        this(
                r.getId(),
                r.getMensaje(),
                r.getSolucion(),
                new DatosAutor(r.getAutor()),
                r.getFechaCreacion(),
                new DatosTopico(r.getTopico()));
    }
}
