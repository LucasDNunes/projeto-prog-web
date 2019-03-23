package br.unisul.progweb.domain.estado;

import br.unisul.progweb.core.support.service.BaseService;

import java.util.List;

public interface EstadoService extends BaseService<Estado, Long> {

    List<Estado> ListarPorOrdemAlfabetica();
}
