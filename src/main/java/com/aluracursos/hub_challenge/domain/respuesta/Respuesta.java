package com.aluracursos.hub_challenge.domain.respuesta;

import com.aluracursos.hub_challenge.domain.publicacion.Publicacion;
import com.aluracursos.hub_challenge.domain.topico.DatosRegistroTopico;
import com.aluracursos.hub_challenge.domain.topico.Topico;
import com.aluracursos.hub_challenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "respuestas")
public class Respuesta extends Publicacion {
    @ManyToOne
    @JoinColumn(name = "id_topico", nullable = false)
    private Topico topico;
    private String solucion;

    public Respuesta(DatosRegistroTopico topico, Usuario autor) {
        super(topico, autor);
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
}
