package br.unisul.progweb.domain.endereco;

import br.unisul.progweb.core.support.entity.BaseEntity;
import br.unisul.progweb.domain.cidade.Cidade;
import br.unisul.progweb.domain.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco implements BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
