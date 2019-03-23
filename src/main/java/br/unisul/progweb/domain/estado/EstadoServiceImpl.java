package br.unisul.progweb.domain.estado;

import br.unisul.progweb.core.support.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl extends AbstractService<Estado, Long, EstadoRepository> implements EstadoService {
    @Override
    public List<Estado> ListarPorOrdemAlfabetica() {
        return repo.findAllbyOrderByNome();
    }
}
