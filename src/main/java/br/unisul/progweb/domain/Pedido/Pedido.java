package br.unisul.progweb.domain.Pedido;

import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.domain.cliente.Cliente;
import br.unisul.progweb.domain.endereco.Endereco;
import br.unisul.progweb.domain.itempedido.ItemPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instante;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy="id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido(Long id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
        super();
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
}
