package br.unisul.progweb.domain.categoria;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
}
