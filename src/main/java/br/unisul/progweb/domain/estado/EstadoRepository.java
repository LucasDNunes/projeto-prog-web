package br.unisul.progweb.domain.estado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Transactional(readOnly = true)
    Page<Estado> findAllByOrderByNome(Pageable pageable);
}
