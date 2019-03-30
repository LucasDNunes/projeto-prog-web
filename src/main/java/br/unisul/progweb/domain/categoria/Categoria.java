package br.unisul.progweb.domain.categoria;

import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.domain.produto.Produto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
public class Categoria implements BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();

    @Builder
    public Categoria(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }
}





