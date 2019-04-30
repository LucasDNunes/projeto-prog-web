package br.unisul.progweb.domain.estado;

import br.unisul.progweb.core.support.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstadoServiceImpl extends AbstractService<Estado, Long, EstadoRepository> implements EstadoService {
    @Override
    public Page<Estado> listarPagina(Pageable pageable) {
        return repo.findAllByOrderByNome(pageable);
    }
}
