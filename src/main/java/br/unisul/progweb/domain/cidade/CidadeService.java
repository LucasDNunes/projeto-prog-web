package br.unisul.progweb.domain.cidade;

import br.unisul.progweb.core.support.service.BaseService;

import java.util.List;

public interface CidadeService extends BaseService<Cidade, Long> {

    List<Cidade> buscarPorEstado(Long idEstado);
}
