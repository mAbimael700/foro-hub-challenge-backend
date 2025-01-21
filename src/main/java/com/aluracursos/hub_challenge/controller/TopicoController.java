package com.aluracursos.hub_challenge.controller;

import com.aluracursos.hub_challenge.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DatosTopico> registrarTopico(@Valid @RequestBody DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoService.registrarTopico(datos);
        var datosTopico = new DatosTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosTopico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosConsultaTopico> obtenerPorId(@PathVariable Long id) {
        var topico = topicoService.obtenerPorId(id);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopico>> obtenerListadoTopicos(Pageable pageable) {
        var pages = topicoService.obtenerListado(pageable);
        return ResponseEntity.ok(pages);
    }

    @PutMapping
    public ResponseEntity<DatosTopico> actualizar(@RequestBody @Valid DatosActualizarTopico datos){
        var topico = topicoService.actualizarTopico(datos);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarRegistro(@PathVariable Long id){
        topicoService.desactivarRegistro(id);
        return ResponseEntity.ok().build();
    }
}
