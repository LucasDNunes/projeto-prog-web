package br.unisul.progweb.domain.cliente;

import br.unisul.progweb.controller.dto.ClienteNewDto;
import br.unisul.progweb.core.support.service.BaseService;

public interface ClienteService extends BaseService<Cliente, Long> {

    Cliente fromDTO(ClienteNewDto objDto);
}
