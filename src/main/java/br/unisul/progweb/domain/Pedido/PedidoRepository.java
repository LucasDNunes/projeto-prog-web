package br.unisul.progweb.domain.Pedido;

import br.unisul.progweb.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Transactional(readOnly=true)
    List<Pedido> findByCliente(Cliente cliente);
}
