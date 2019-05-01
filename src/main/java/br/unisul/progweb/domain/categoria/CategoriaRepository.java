package br.unisul.progweb.domain.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNomeContaining(String nome);
}
