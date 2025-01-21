package com.aluracursos.hub_challenge.domain.curso;
import com.aluracursos.hub_challenge.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private CategoriaCurso categoria;
    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public CategoriaCurso getCategoria() {
        return categoria;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(CategoriaCurso categoria) {
        this.categoria = categoria;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
}
