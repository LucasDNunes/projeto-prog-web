package br.unisul.progweb.core.support.repository;

import br.unisul.progweb.domain.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/* deveria sert E extends BaseEntity*/
public interface BaseRepository<E extends Categoria, K extends Serializable>
        extends JpaRepository<E, K>, JpaSpecificationExecutor<E> {
}
