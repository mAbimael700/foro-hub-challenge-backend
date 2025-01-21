package com.aluracursos.hub_challenge.domain.topico;

import com.aluracursos.hub_challenge.domain.curso.Curso;
import com.aluracursos.hub_challenge.domain.publicacion.Publicacion;
import com.aluracursos.hub_challenge.domain.respuesta.Respuesta;
import com.aluracursos.hub_challenge.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "topicos")
public class Topico extends Publicacion {

    private String titulo;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Estado estado;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;
    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;
    private Boolean activo;

    public Topico() {
        super();  // Proporciona valores por defecto para la superclase
    }

    public Topico(DatosRegistroTopico datos, Curso curso, Usuario autor) {
        super(datos, autor);
        this.titulo = datos.titulo();
        this.estado = datos.estado();
        this.curso = curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public Estado getEstado() {
        return estado;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if (datos.mensaje() != null) {
            this.setMensaje(datos.mensaje());
        }
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.estado() != null) {
            this.estado = datos.estado();
        }
    }

    public void setActivo(boolean b) {
        this.activo = b;
    }
}
