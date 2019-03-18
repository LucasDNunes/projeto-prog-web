package br.unisul.progweb.core.support.controller;

import br.unisul.progweb.core.exception.RegistroNaoEncontradoException;
import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.core.support.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@Slf4j
public abstract class AbstractController<E extends BaseEntity, K extends Serializable, S extends BaseService<E, K>>
        implements BaseController<E, K> {

    @Autowired
    protected S service;

    public Page<E> listarPagina(@PageableDefault Pageable pageable) {
        return service.listarPagina(pageable);
    }

    public Page<E> listarPorParticula(@RequestParam("particula") String particula,
                                      @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return service.listarPorParticula(particula, pageable);
    }

    public ResponseEntity<E> incluir(@RequestBody E e) {
        return ResponseEntity.ok().body(service.salvar(e));
    }

    public ResponseEntity<Optional<E>> buscarPorId(@PathVariable K id) {
        log.debug("Pesquisando objeto com id {}", id);
        final Optional<E> entity = service.buscarPorId(id);
        log.debug("Pesquisou {} com id {}", entity.getClass().getSimpleName(), id);
        if (!entity.isPresent()) {
            throw new RegistroNaoEncontradoException(((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName(), id);
        }
        log.debug("Encontrou {} com id {}", entity.getClass().getSimpleName(), id);
        return ResponseEntity.ok().body(entity);
    }

    public ResponseEntity<Object> atualizar(@RequestBody E e, @PathVariable K id) {
        if (service.existe(id)) {
            return ResponseEntity.ok().body(service.salvar(e));
        } else {
            throw new RegistroNaoEncontradoException(e.getClass().getSimpleName(), id);
        }
    }

    public ResponseEntity<Object> excluir(@PathVariable K id) {
        if (service.excluir(id)) {
            return ResponseEntity.ok().build();
        }
        throw new RegistroNaoEncontradoException("Registro", id);
    }

}
