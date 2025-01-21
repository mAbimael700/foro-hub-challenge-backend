package com.aluracursos.hub_challenge.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("""
            SELECT t FROM Topico t
                    WHERE t.titulo = :titulo
                    AND t.mensaje = :mensaje
            """)
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);


    Page<Topico> findByActivoTrue(Pageable paginacion);
}
