package br.unisul.progweb.controller;

import br.unisul.progweb.controller.dto.EstadoDto;
import br.unisul.progweb.core.support.controller.AbstractController;
import br.unisul.progweb.domain.estado.Estado;
import br.unisul.progweb.domain.estado.EstadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController extends AbstractController<Estado, EstadoDto, Long, EstadoService> {

}
