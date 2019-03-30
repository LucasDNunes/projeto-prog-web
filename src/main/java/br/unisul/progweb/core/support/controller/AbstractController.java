package br.unisul.progweb.core.support.controller;

import br.unisul.progweb.core.exception.RegistroNaoEncontradoException;
import br.unisul.progweb.core.support.entity.BaseDto;
import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.core.support.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractController<E extends BaseEntity, D extends BaseDto, K extends Serializable, S extends BaseService<E, K>>
        implements BaseController<E, D, K> {

    @Autowired
    protected S service;
    private Class<D> dto;
    private Class<E> entidade;

    @Autowired
    private ModelMapper modelMapper;

    protected AbstractController() {
        /* tentar esse metodo em vez de pegar do parametro*/
        final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.dto = (Class<D>) (type).getActualTypeArguments()[0];
//        dto.getClass();
//        this.dto = dto;
        this.entidade = (Class<E>) (type).getActualTypeArguments()[0];
    }

    public Page<D> listarPagina(@PageableDefault(size = Integer.MAX_VALUE) Pageable pageable) {
        List<D> dtos = service.listarPagina(pageable).getContent().stream()
                .map(e -> modelMapper.map(e, dto)).collect(Collectors.toList());
        return new PageImpl<>(dtos);
    }

    public Page<E> listarPorParticula(@RequestParam("particula") String particula,
                                      @PageableDefault Pageable pageable) {
        return service.listarPorParticula(particula, pageable);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public D incluir(@RequestBody D e) {
        E map = modelMapper.map(e, entidade);
        map = service.salvar(map);
        return modelMapper.map(map, dto);
    }

    @Override
    public Optional<D> buscarPorId(@PathVariable K id) {
        log.debug("Pesquisando objeto com id {}", id);
        final Optional<E> entity = service.buscarPorId(id);
        log.debug("Pesquisou {} com id {}", entity.getClass().getSimpleName(), id);
        if (!entity.isPresent()) {
            throw new RegistroNaoEncontradoException(((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName(), id);
        }
        log.debug("Encontrou {} com id {}", entity.getClass().getSimpleName(), id);
        return Optional.of(modelMapper.map(entity.get(), dto));
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    public Object atualizar(@RequestBody D d, @PathVariable K id) {
        if (service.existe(id)) {
            E e = modelMapper.map(d, entidade);
            e = service.salvar(e);
            return modelMapper.map(e, dto);
        } else {
            throw new RegistroNaoEncontradoException(d.getClass().getSimpleName(), id);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object excluir(@PathVariable K id) {
        if (service.excluir(id)) {
            return ResponseEntity.EMPTY;
        }
        throw new RegistroNaoEncontradoException("Registro", id);
    }

}
