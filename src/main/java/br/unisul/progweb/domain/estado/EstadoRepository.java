package br.unisul.progweb.domain.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Transactional(readOnly = true)
    List<Estado> findAllbyOrderByNome();
}
