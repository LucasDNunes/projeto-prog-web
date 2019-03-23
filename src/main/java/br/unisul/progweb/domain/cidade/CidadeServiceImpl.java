package br.unisul.progweb.domain.cidade;

import br.unisul.progweb.core.support.service.AbstractService;

import java.util.List;

public class CidadeServiceImpl extends AbstractService<Cidade, Long, CidadeRepository> implements CidadeService {

    @Override
    public List<Cidade> BuscarPorEstado(Long idEstado) {
        return repo.findCidades(idEstado);
    }
}
