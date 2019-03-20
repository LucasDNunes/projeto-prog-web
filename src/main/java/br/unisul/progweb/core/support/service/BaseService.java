package br.unisul.progweb.core.support.service;

import br.unisul.progweb.core.support.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService<T extends BaseEntity, K extends Serializable> {
    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity
     * @return the saved entity
     */
    T salvar(T entity, boolean valida);

    T salvar(T entity);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    Page<T> listarPagina(Pageable pageable);

    Page<T> listarPorParticula(String particula, Pageable pageable);

//    Page<T> listarPorSpecification(String params, Pageable pageable);

    /**
     * Deletes a given entity.
     *
     * @param id
     */
    Boolean excluir(K id);

    /**
     * View a given entity.
     *
     * @param id
     */
    Optional<T> buscarPorId(K id);

    long quantidadeTotal();

    Boolean existe(K id);

    void flush();

}
