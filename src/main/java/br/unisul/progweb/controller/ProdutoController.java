package br.unisul.progweb.controller;

import br.unisul.progweb.controller.dto.ProdutoDto;
import br.unisul.progweb.core.support.controller.AbstractController;
import br.unisul.progweb.core.utils.URL;
import br.unisul.progweb.domain.produto.Produto;
import br.unisul.progweb.domain.produto.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends AbstractController<Produto, ProdutoDto, Long, ProdutoService> {

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/busca-categoria")
    public List<ProdutoDto> buscarNomeCategoria(@RequestParam(value = "nome") String nome,
                                                @RequestParam(value = "categorias") String categorias) {

        String nomeDecoded = URL.decodeParam(nome);
        List<Long> ids = URL.decodeIntList(categorias);
        return service.buscarProdutoPorNomeContidaEmCategorias(nomeDecoded, ids).stream()
                .map(p -> modelMapper.map(p, ProdutoDto.class)).collect(Collectors.toList());
    }
}
