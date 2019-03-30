package br.unisul.progweb.domain.produto;

import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.domain.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private Double valor;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @Builder
    public Produto(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
        this.categorias = new ArrayList<>();
    }
}
