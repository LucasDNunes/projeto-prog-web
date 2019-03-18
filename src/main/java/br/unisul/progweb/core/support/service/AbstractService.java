package br.unisul.progweb.core.support.service;

import br.unisul.progweb.core.support.MessageBundle;
import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.core.support.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.persistence.jpa.jpql.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.jpa.JpaOptimisticLockingFailureException;

import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public abstract class AbstractService<E extends BaseEntity, K extends Serializable, R extends BaseRepository<E, K>>
        implements BaseService<E, K> {

    @Autowired
    protected R repo;

    protected void validarEntity(E entity) {

    }

    @Override
    @Transactional
    public E salvar(E entity, boolean valida) {
        E entitySalva = null;
        try {
            log.debug("Salvando objeto " + entity.getClass() + " : " + entity.toString());
            entitySalva = repo.save(entity);
            if (valida) {
                validarEntity(entitySalva);
            } else {
                flush();
            }
        } catch (ConstraintViolationException e) {
            capturaException(e);
        } catch (JpaOptimisticLockingFailureException jpaOFE) {
            throw new OptimisticLockException(MessageBundle.getMessage("exception.versaoIncorretaDoObjeto"));
        }
        return entitySalva;
    }

    @Override
    @Transactional
    public E salvar(E entity) {
        return salvar(entity, true);
    }

    @Override
    public Page<E> listarPagina(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Page<E> listarPorParticula(String particula, Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    @Transactional
    public Boolean excluir(K id) {
        try {
            log.debug("Excluindo objeto com id: " + id);
            repo.deleteById(id);
            return Boolean.TRUE;
        } catch (ConstraintViolationException e) {
            capturaException(e);
        }
        return false;
    }

    public void flush() {
        repo.flush();
    }

    @Override
    public Optional<E> buscarPorId(K id) {
        Optional<E> entity = null;
        try {
            entity = repo.findById(id);

        } catch (Exception e) {
            Optional<Throwable> rootCause = Stream.iterate(e, Throwable::getCause)
                    .filter(element -> element.getCause() == null).findFirst();
            if (rootCause.isPresent() && (rootCause.get() instanceof ConstraintViolationException)) {
                ConstraintViolationException excecao = (ConstraintViolationException) rootCause.get();
                capturaException(excecao);
            }
            throw e;
        }
        return entity;
    }

    @Override
    public long quantidadeTotal() {
        return repo.count();
    }

    public R getRepository() {
        return repo;
    }

    @Override
    public Boolean existe(K id) {
        return repo.existsById(id);
    }

    private void capturaException(ConstraintViolationException excecao) {
        Iterator<ConstraintViolation<?>> iterator = excecao.getConstraintViolations().iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<?> cv = iterator.next();
            String erro = cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " "
                    + cv.getMessage();
            Assert.fail(erro);
        }
    }
}
