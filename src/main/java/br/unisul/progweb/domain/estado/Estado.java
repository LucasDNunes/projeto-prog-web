package br.unisul.progweb.domain.estado;

import br.unisul.progweb.core.support.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "estado")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estado implements BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "uf")
    private String uf;
}
