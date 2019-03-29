package br.unisul.progweb.controller;

import br.unisul.progweb.controller.dto.CategoriaDto;
import br.unisul.progweb.core.support.controller.AbstractController;
import br.unisul.progweb.domain.categoria.Categoria;
import br.unisul.progweb.domain.categoria.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends AbstractController<Categoria, CategoriaDto, Long, CategoriaService> {

}
