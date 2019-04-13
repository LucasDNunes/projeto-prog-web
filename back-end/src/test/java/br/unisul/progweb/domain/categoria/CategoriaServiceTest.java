package br.unisul.progweb.domain.categoria;

import br.unisul.progweb.ProgWebApplicationServerTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaServiceTest extends ProgWebApplicationServerTests {

    @Autowired
    CategoriaService categoriaService;

    @Test
    public void test(){

        System.out.printf("11");
        categoriaService.salvar(Categoria.builder().nome("teste").build());
        System.out.printf("salvou");
    }
}
