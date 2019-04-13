package br.unisul.progweb.domain.produto;

import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.domain.Pedido.Pedido;
import br.unisul.progweb.domain.categoria.Categoria;
import br.unisul.progweb.domain.itempedido.ItemPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Produto implements BaseEntity {

    private static final long serialVersionUID = 89461695146L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double preco;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    @Builder
    public Produto(String nome, Double valor) {
        this.nome = nome;
        this.preco = valor;
        this.categorias = new ArrayList<>();
    }

    @JsonIgnore
    public List<Pedido> getPedidos() {
        List<Pedido> lista = new ArrayList<>();
        for (ItemPedido x : itens) {
            lista.add(x.getPedido());
        }
        return lista;
    }

    public double getValorTotal() {
        Double soma = 0.0;
        for (ItemPedido ip : itens) {
            soma = soma + ip.getSubTotal();
        }
        return soma;
    }
}
