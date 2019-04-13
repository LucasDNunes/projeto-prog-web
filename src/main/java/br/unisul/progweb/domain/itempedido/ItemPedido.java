package br.unisul.progweb.domain.itempedido;

import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.domain.Pedido.Pedido;
import br.unisul.progweb.domain.itempedidopk.ItemPedidoPk;
import br.unisul.progweb.domain.produto.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPedido implements BaseEntity {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPk id = new ItemPedidoPk();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public double getSubTotal() {
        return (preco - desconto) * quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        StringBuilder builder = new StringBuilder();
        builder.append(getProduto().getNome());
        builder.append(", Qte: ");
        builder.append(getQuantidade());
        builder.append(", Preço unitário: ");
        builder.append(nf.format(getPreco()));
        builder.append(", Subtotal: ");
        builder.append(nf.format(getSubTotal()));
        builder.append("\n");
        return builder.toString();
    }

}
