package br.unisul.progweb.core.support.repository;

import br.unisul.progweb.core.support.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseRepository<E extends BaseEntity, K extends Serializable>
        extends JpaRepository<E, K>, JpaSpecificationExecutor<E> {
}
