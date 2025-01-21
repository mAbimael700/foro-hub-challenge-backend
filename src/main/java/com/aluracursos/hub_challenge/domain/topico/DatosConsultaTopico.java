package com.aluracursos.hub_challenge.domain.topico;

import com.aluracursos.hub_challenge.domain.curso.DatosCurso;
import com.aluracursos.hub_challenge.domain.respuesta.DatosRespuesta;
import com.aluracursos.hub_challenge.domain.usuario.DatosAutor;

import java.time.LocalDateTime;

public record DatosConsultaTopico(String titulo,
                                  String mensaje,
                                  Estado estado,
                                  DatosAutor autor,
                                  LocalDateTime fechaCreacion,
                                  DatosCurso curso) {

    public DatosConsultaTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstado(),
                new DatosAutor(topico.getAutor()),
                topico.getFechaCreacion(),
                new DatosCurso(topico.getCurso())
        );
    }

}
