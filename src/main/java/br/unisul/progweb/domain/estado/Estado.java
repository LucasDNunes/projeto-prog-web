package br.unisul.progweb.domain.estado;

import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.domain.cidade.Cidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estado")
@Setter
@Getter
@NoArgsConstructor
public class Estado implements BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "uf")
    private String uf;

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    @Builder
    public Estado(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
        this.cidades = new ArrayList<>();
    }
}
