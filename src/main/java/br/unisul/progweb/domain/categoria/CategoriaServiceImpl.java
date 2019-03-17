package br.unisul.progweb.domain.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Page<Categoria> listarPagina(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        Categoria buscado = this.buscarPorId(categoria.getId())
                .orElseThrow(() -> new IllegalArgumentException("Não achou com o id" + categoria.getId()));
        categoria.setId(buscado.getId());
        return this.salvar(categoria);
    }

    @Override
    public void excluir(Long id) {
        categoriaRepository.deleteById(id);
    }


}
