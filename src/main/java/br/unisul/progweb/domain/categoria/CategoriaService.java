package br.unisul.progweb.domain.categoria;

import br.unisul.progweb.core.support.service.BaseService;

import java.util.List;

public interface CategoriaService extends BaseService<Categoria, Long> {

    List<Categoria> buscarTodosPorId(List<Long> ids);

}
