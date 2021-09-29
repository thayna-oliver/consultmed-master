package com.uninassau.programacao.avancada.consultmed.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EnderecoDto {

    private Long id;

   @Size(max = 255)
   @NotEmpty
    private String rua;

    @Size(max = 255)
    @NotBlank
    private String bairro;

    @Size(max = 255)
    @NotEmpty
    private String cidade;

    @Size(max = 255)
    @NotEmpty
    private String estado;

    @Size(max = 9)
    @NotEmpty
    private String cep;
}
