package br.unisul.progweb.controller.dto;

import br.unisul.progweb.core.support.entity.BaseDto;
import br.unisul.progweb.domain.estado.Estado;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadeDto extends BaseDto {

    private Long id;
    private String nome;
    private Estado estado;
}
