package br.unisul.progweb.domain.cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CidadeRepository  extends JpaRepository<Cidade, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Cidade WHERE obj.estado.id = :estadoId Order By obj.nome")
    List<Cidade> findCidades(@Param("estadoId") Long idestado);
}
