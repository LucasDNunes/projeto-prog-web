package br.unisul.progweb.core.support.controller;

import br.unisul.progweb.core.support.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public interface BaseController<E extends BaseEntity, K extends Serializable> {

    @GetMapping
    Page<E> listarPagina(@PageableDefault Pageable pageable);

    @GetMapping(params = {"particula"})
    Page<E> listarPorParticula(@RequestParam("particula") String particula, @PageableDefault Pageable pageable);

    @PostMapping
    ResponseEntity<E> incluir(@RequestBody E e);

    @GetMapping(value = "/{id}")
    Object buscarPorId(@PathVariable K id);

    @PutMapping(value = "/{id}")
    ResponseEntity<Object> atualizar(@RequestBody E e, @PathVariable K id);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Object> excluir(@PathVariable K id);

}
