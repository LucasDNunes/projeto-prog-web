package br.unisul.progweb.controller;

import br.unisul.progweb.controller.dto.EnderecoDto;
import br.unisul.progweb.core.support.controller.AbstractController;
import br.unisul.progweb.domain.Endereco.Endereco;
import br.unisul.progweb.domain.Endereco.EnderecoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController extends AbstractController<Endereco, EnderecoDto, Long, EnderecoService> {
}
