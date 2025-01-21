    package com.aluracursos.hub_challenge.domain.publicacion;

    import com.aluracursos.hub_challenge.domain.topico.DatosRegistroTopico;
    import com.aluracursos.hub_challenge.domain.usuario.Usuario;
    import jakarta.persistence.*;
    import java.time.LocalDateTime;


    @Entity
    @Table(name = "publicaciones")
    @Inheritance(strategy = InheritanceType.JOINED)
    public abstract class Publicacion {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String mensaje;
        private LocalDateTime fechaCreacion;
        @ManyToOne
        @JoinColumn(name = "id_autor", nullable = false)
        private Usuario autor;

        public Publicacion(){
        }

        public Publicacion(DatosRegistroTopico topico, Usuario autor){
            this.mensaje = topico.mensaje();
            fechaCreacion = LocalDateTime.now();
            this.autor =  autor;
        }

        public Long getId() {
            return id;
        }

        public String getMensaje() {
            return mensaje;
        }

        public Usuario getAutor() {
            return autor;
        }

        public LocalDateTime getFechaCreacion() {
            return fechaCreacion;
        }

        public void setAutor(Usuario autor) {
            this.autor = autor;
        }

        public void setFechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }
