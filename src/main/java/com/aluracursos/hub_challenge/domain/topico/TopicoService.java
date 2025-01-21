package com.aluracursos.hub_challenge.domain.topico;

import com.aluracursos.hub_challenge.domain.curso.CursoRepository;
import com.aluracursos.hub_challenge.domain.topico.validaciones.ValidadorDeTopicos;
import com.aluracursos.hub_challenge.domain.usuario.UsuarioRepository;
import com.aluracursos.hub_challenge.infra.exceptions.TopicoNoEncontradoException;
import com.aluracursos.hub_challenge.infra.exceptions.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<ValidadorDeTopicos> validaciones;

    public Topico registrarTopico(DatosRegistroTopico datos) {

        var curso = cursoRepository.findById(datos.idCurso());
        var autor = usuarioRepository.findById(datos.idUsuario());

        if (curso.isEmpty()) {
            throw new ValidacionException("El curso dado no existe.");
        }

        if (autor.isEmpty()) {
            throw new ValidacionException("El autor dado no existe.");
        }

        validaciones.forEach(v -> v.validar(datos));

        var topico = new Topico(datos, curso.get(), autor.get());
        return topicoRepository.save(topico);
    }

    public DatosConsultaTopico obtenerPorId(Long id) {
        var consultaTopico = topicoRepository.findById(id);
        if (consultaTopico.isEmpty()) {
            throw new TopicoNoEncontradoException(id);
        }
        return new DatosConsultaTopico(consultaTopico.get());
    }

    public Page<DatosTopico> obtenerListado(Pageable pageable) {
        return topicoRepository.findByActivoTrue(pageable).map(DatosTopico::new);
    }

    public DatosTopico actualizarTopico(DatosActualizarTopico datos) {
        var topico = topicoRepository.findById(datos.id())
                .orElseThrow(() -> new TopicoNoEncontradoException(datos.id()));

        validaciones.forEach(v -> v.validar(datos));
        topico.actualizarDatos(datos);

        // Guardar y devolver los datos actualizados
        return new DatosTopico(topicoRepository.save(topico));

    }

    public void desactivarRegistro(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new TopicoNoEncontradoException(id));

        topico.setActivo(false);
        topicoRepository.save(topico);
    }
}
