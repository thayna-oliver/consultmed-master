package com.uninassau.programacao.avancada.consultmed.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EspecialidadeMedicaDto {

    private Long id;

    @Length(max = 60)
    private String descricao;
}
