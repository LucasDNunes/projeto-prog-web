package br.unisul.progweb.config;

import br.unisul.progweb.domain.categoria.Categoria;
import br.unisul.progweb.domain.categoria.CategoriaRepository;
import br.unisul.progweb.domain.produto.Produto;
import br.unisul.progweb.domain.produto.ProdutopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DbService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutopRepository produtopRepository;


    public void inicializaBancoDeDados() throws ParseException {

//		List<Categoria> categorias = categoriaService.listarPagina(PageRequest.of(0, 2)).getContent();
//
        Produto p1 = Produto.builder()
                .nome("Computador")
                .valor(2000.0)
                .build();

        Produto p2 = Produto.builder()
                .nome("Impressora")
                .valor(800.0)
                .build();

        Produto p3 = Produto.builder()
                .nome("Impressora")
                .valor(800.0)
                .build();

//		repository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        Categoria cat1 = Categoria.builder()
                .nome("Informática")
                .build();
        Categoria cat2 = Categoria.builder()
                .nome("Escritório")
                .build();
        Categoria cat3 = Categoria.builder().nome("Cama mesa e banho").build();
        Categoria cat4 = Categoria.builder().nome("Eletrônicos").build();
//		Categoria cat5 = new Categoria(null, "Jardinagem");
//		Categoria cat6 = new Categoria(null, "Decoração");
//		Categoria cat7 = new Categoria(null, "Perfumaria");

//		Produto p1 = new Produto("Computador", 2000.00);
//		Produto p2 = new Produto(null, "Impressora", 800.00);
//		Produto p3 = new Produto(null, "Mouse", 80.00);
        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));
        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        produtopRepository.saveAll(Arrays.asList(p1, p2, p3));
    }

}
