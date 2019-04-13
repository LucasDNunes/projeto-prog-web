package br.unisul.progweb.controller;

import br.unisul.progweb.controller.dto.ClienteDto;
import br.unisul.progweb.controller.dto.ClienteNewDto;
import br.unisul.progweb.core.support.controller.AbstractController;
import br.unisul.progweb.domain.cliente.Cliente;
import br.unisul.progweb.domain.cliente.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends AbstractController<Cliente, ClienteDto, Long, ClienteService> {

    @Autowired
    private final ModelMapper modelMapper;

    public ClienteController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/inserir")
    public ClienteDto inserir(@RequestBody ClienteNewDto cliente) {
        Cliente obj = service.fromDTO(cliente);
        obj = service.salvar(obj);
        return modelMapper.map(obj, ClienteDto.class);
    }
}
