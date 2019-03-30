package br.unisul.progweb.domain.cidade;

import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.domain.estado.Estado;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Cidade implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @Builder
    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }
}
