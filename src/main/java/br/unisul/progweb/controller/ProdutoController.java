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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends AbstractController<Produto, ProdutoDto, Long, ProdutoService> {

    public ProdutoController() {
        super(ProdutoDto.class, Produto.class);
    }

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<ProdutoDto> buscarNomeCategoria(@RequestParam(value = "nome") String nome,
                                                @RequestParam(value = "categorias") String categorias){



        String nomeDecoded = URL.decodeParam(nome);
        List<Long> ids = URL.decodeIntList(categorias);
        List<Produto> list = service.buscarProdutoPorNomeContidaEmCategorias(nomeDecoded, ids);
        List<ProdutoDto> listDto = new ArrayList<>();
        for (Produto p : list) {
            listDto.add(modelMapper.map(p, ProdutoDto.class));
        }
        return (listDto);
    }
}
