package br.unisul.progweb.domain.cidade;

import br.unisul.progweb.core.support.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl extends AbstractService<Cidade, Long, CidadeRepository> implements CidadeService {

    @Override
    public List<Cidade> BuscarPorEstado(Long idEstado) {
        return repo.findCidades(idEstado);
    }
}
