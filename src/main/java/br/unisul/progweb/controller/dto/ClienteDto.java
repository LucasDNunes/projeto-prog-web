package br.unisul.progweb.controller.dto;

import br.unisul.progweb.core.support.entity.BaseDto;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDto extends BaseDto {

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;
    private String cpfOuCnpj;
    private Long tipo;
    private List<EnderecoDto> enderecos;
    private Set<String> telefones;
}
