package br.unisul.progweb.domain.produto;

import br.unisul.progweb.domain.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface ProdutopRepository extends JpaRepository<Produto, Long> {

    List<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias);
}
