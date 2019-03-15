package br.unisul.progweb.controller;

import br.unisul.progweb.domain.categoria.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @GetMapping
    public List<Categoria> listar() {
        return Collections.singletonList(Categoria.builder()
                .id(1L)
                .nome("teste")
                .build());
    }
}
