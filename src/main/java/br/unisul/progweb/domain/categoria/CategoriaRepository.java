package br.unisul.progweb.domain.categoria;

import br.unisul.progweb.core.support.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
