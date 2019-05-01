package br.unisul.progweb.controller;

import br.unisul.progweb.controller.dto.CategoriaDto;
import br.unisul.progweb.core.support.controller.AbstractController;
import br.unisul.progweb.domain.categoria.Categoria;
import br.unisul.progweb.domain.categoria.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends AbstractController<Categoria, CategoriaDto, Long, CategoriaService> {

    private final ModelMapper modelMapper;

    @Autowired
    public CategoriaController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping(params = {"nome"})
    public List<CategoriaDto> buscarPornome(@RequestParam String nome) {
        List<Categoria> categorias = service.listarPorNome(nome);
        return categorias.stream().map(c -> modelMapper.map(c, CategoriaDto.class)).collect(Collectors.toList());
    }
}
