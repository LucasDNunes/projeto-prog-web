package br.unisul.progweb.controller;

import br.unisul.progweb.controller.dto.CidadeDto;
import br.unisul.progweb.controller.dto.EstadoDto;
import br.unisul.progweb.core.support.controller.AbstractController;
import br.unisul.progweb.domain.cidade.Cidade;
import br.unisul.progweb.domain.cidade.CidadeService;
import br.unisul.progweb.domain.estado.Estado;
import br.unisul.progweb.domain.estado.EstadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados")
public class EstadoController extends AbstractController<Estado, EstadoDto, Long, EstadoService> {

    private final CidadeService cidadeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EstadoController(CidadeService cidadeService, ModelMapper modelMapper) {
        this.cidadeService = cidadeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/{estadoId}/cidades")
    public ResponseEntity<List<CidadeDto>> findCidades(@PathVariable Long estadoId) {
        List<Cidade> list = cidadeService.BuscarPorEstado(estadoId);
        List<CidadeDto> listDto = list.stream().map(c -> modelMapper.map(c, CidadeDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
