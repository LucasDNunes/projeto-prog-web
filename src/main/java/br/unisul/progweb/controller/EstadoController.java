package br.unisul.progweb.controller;

import br.unisul.progweb.controller.dto.EstadoDto;
import br.unisul.progweb.core.support.controller.AbstractController;
import br.unisul.progweb.domain.estado.Estado;
import br.unisul.progweb.domain.estado.EstadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController extends AbstractController<Estado, EstadoDto, Long, EstadoService> {

    private final ModelMapper modelMapper;
    private final EstadoService estadoService;

    @Autowired
    public EstadoController(ModelMapper modelMapper, EstadoService estadoService) {
        super(EstadoDto.class, Estado.class);
        this.modelMapper = modelMapper;
        this.estadoService = estadoService;
    }

    @Override
    public Page<EstadoDto> listarPagina(Pageable pageable) {
        //usar esse cara
//        return new PageImpl<>(service.ListarPorOrdemAlfabetica());
        return super.listarPagina(pageable);
    }
}
