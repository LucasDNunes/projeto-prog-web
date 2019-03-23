package br.unisul.progweb.domain.produto;

import br.unisul.progweb.core.support.service.BaseService;

import java.util.List;

public interface ProdutoService extends BaseService<Produto, Long> {

    List<Produto> buscarProdutoPorNomeContidaEmCategorias(String nome, List<Long> idsCategorias);
}
