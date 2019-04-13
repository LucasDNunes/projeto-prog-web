package br.unisul.progweb.domain.categoria;

import br.unisul.progweb.core.support.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl extends AbstractService<Categoria, Long, CategoriaRepository> implements CategoriaService {

    @Override
    public List<Categoria> buscarTodosPorId(List<Long> ids) {
        return repo.findAllById(ids);
    }
}
