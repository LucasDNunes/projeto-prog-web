package br.unisul.progweb.core.support.controller;

import br.unisul.progweb.core.support.entity.BaseDto;
import br.unisul.progweb.core.support.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;

public interface BaseController<E extends BaseEntity, T extends BaseDto, K extends Serializable> {

    @GetMapping
    Page<T> listarPagina(@PageableDefault Pageable pageable);

    @GetMapping(params = {"particula"})
    Page<E> listarPorParticula(@RequestParam("particula") String particula, @PageableDefault Pageable pageable);

    @PostMapping
    T incluir(@RequestBody T e);

    @GetMapping(value = "/{id}")
    Optional<T> buscarPorId(@PathVariable K id);

    @PutMapping(value = "/{id}")
    Object atualizar(@RequestBody T e, @PathVariable K id);

    @DeleteMapping(value = "/{id}")
    Object excluir(@PathVariable K id);

}
