package com.aluracursos.hub_challenge.domain.topico.validaciones;

import com.aluracursos.hub_challenge.domain.topico.DatosActualizarTopico;
import com.aluracursos.hub_challenge.domain.topico.DatosRegistroTopico;
import com.aluracursos.hub_challenge.domain.topico.Topico;
import com.aluracursos.hub_challenge.domain.topico.TopicoRepository;
import com.aluracursos.hub_challenge.infra.exceptions.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidadorEsDuplicado implements ValidadorDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosRegistroTopico datos) {

        var busquedaTopicoDuplicado = topicoRepository.findByTituloAndMensaje(datos.titulo(), datos.mensaje());

        if (busquedaTopicoDuplicado.isPresent()) {
            throw new ValidacionException("No puede existir un tópico duplicado");
        }
    }

    @Override
    public void validar(DatosActualizarTopico datos) {

        var topicoRef = topicoRepository.getReferenceById(datos.id());

        Optional<Topico> busquedaTopicoDuplicado = Optional.empty();

        if (datos.titulo() != null && datos.mensaje() == null) {
            busquedaTopicoDuplicado = topicoRepository.findByTituloAndMensaje(datos.titulo(),
                    topicoRef.getMensaje());
        }

        if (datos.titulo() == null && datos.mensaje() != null) {
            busquedaTopicoDuplicado = topicoRepository.findByTituloAndMensaje(topicoRef.getTitulo(),
                    datos.mensaje());
        }

        if (datos.titulo() != null && datos.mensaje() != null) {
            busquedaTopicoDuplicado = topicoRepository.findByTituloAndMensaje(datos.titulo(),
                    datos.mensaje());
        }

        if (busquedaTopicoDuplicado.isPresent()) {
            throw new ValidacionException("No puede existir un tópico duplicado");
        }
    }
}
