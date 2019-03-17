package br.unisul.progweb.domain.categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoriaService {

    Optional<Categoria> buscarPorId(Long id);

    Page<Categoria> listarPagina(Pageable pageable);

    Categoria salvar(Categoria categoria);

    Categoria atualizar(Categoria categoria);

    void excluir(Long id);
}
