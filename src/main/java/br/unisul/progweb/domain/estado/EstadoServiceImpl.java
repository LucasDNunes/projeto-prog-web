package br.unisul.progweb.domain.estado;

import br.unisul.progweb.core.support.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class EstadoServiceImpl extends AbstractService<Estado, Long, EstadoRepository> implements EstadoService {
}
