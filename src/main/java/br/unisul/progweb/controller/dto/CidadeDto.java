package br.unisul.progweb.controller.dto;

import br.unisul.progweb.core.support.entity.BaseDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadeDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private EstadoDto estado;
}
