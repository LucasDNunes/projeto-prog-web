package br.unisul.progweb.controller.dto;

import br.unisul.progweb.core.support.entity.BaseDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteNewDto extends BaseDto {

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Long tipo;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Long cidadeId;
}
