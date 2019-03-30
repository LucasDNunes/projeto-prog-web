package br.unisul.progweb.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
