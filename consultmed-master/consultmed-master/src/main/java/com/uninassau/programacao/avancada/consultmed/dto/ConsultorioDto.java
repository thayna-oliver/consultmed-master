package com.uninassau.programacao.avancada.consultmed.dto;


import com.uninassau.programacao.avancada.consultmed.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultorioDto {

    private Long id;

    @Size(max = 50)
    @NotEmpty
    private EnderecoDto endereco;

    @Size(max = 50)
    @NotEmpty
    private String nomeFantasia;

    @Size(max = 14)
    @NotEmpty
    private String cnpj;


}
