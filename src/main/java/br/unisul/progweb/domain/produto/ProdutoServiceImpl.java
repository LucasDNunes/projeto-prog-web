package br.unisul.progweb.domain.produto;

import br.unisul.progweb.core.support.service.AbstractService;
import br.unisul.progweb.core.utils.URL;
import br.unisul.progweb.domain.categoria.Categoria;
import br.unisul.progweb.domain.categoria.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl extends AbstractService<Produto, Long, ProdutopRepository> implements ProdutoService {

    private final CategoriaService categoriaService;

    @Autowired
    public ProdutoServiceImpl(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Override
    public List<Produto> buscarProdutoPorNomeContidaEmCategorias(String nome, List<Long> idsCategorias) {
        List<Categoria> categorias = categoriaService.BuscarTodosPorId(idsCategorias);
        return repo.findDistinctByNomeContaningAndCategoriasIn(nome, categorias);
    }

    public List<Produto> buscarProdutoPorNomeContidaEmCategorias(String nome, String categorias){
        String nomeDecoded = URL.decodeParam(nome);
        List<Long> ids = URL.decodeIntList(categorias);
        return this.buscarProdutoPorNomeContidaEmCategorias(nomeDecoded, ids);
    }
}
