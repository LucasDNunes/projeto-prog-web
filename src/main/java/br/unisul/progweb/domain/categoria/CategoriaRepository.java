package br.unisul.progweb.domain.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
