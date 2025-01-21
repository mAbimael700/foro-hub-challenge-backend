package com.aluracursos.hub_challenge.domain.topico.validaciones;

import com.aluracursos.hub_challenge.domain.topico.DatosActualizarTopico;
import com.aluracursos.hub_challenge.domain.topico.DatosRegistroTopico;

public interface ValidadorDeTopicos {
    void validar(DatosRegistroTopico datos);

    void validar(DatosActualizarTopico datos);
}
