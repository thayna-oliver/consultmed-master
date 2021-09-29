package com.uninassau.programacao.avancada.consultmed.dto;

import com.uninassau.programacao.avancada.consultmed.model.Endereco;
import com.uninassau.programacao.avancada.consultmed.model.EspecialidadeMedica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MedicoDto{
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Endereco endereco;
    private String telefone;
    private String crm;
    private EspecialidadeMedica especialidadeMedica;
}
