package com.uninassau.programacao.avancada.consultmed.dto;

import com.uninassau.programacao.avancada.consultmed.model.EspecialidadeMedica;
import com.uninassau.programacao.avancada.consultmed.model.Medico;
import com.uninassau.programacao.avancada.consultmed.model.Paciente;
import com.uninassau.programacao.avancada.consultmed.model.StatusDoAgendamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FichaAgendamentoDto {

    private Long id;

    @Size(max = 70)
    @NotBlank
    private PacienteDto paciente;

    @Size(max = 70)
    @NotBlank
    private MedicoDto medico;

    @Size(max = 60)
    @NotBlank
    private EspecialidadeMedicaDto especialidade;

    @Size(max = 150)
    @NotEmpty
    private ConsultorioDto consultorio;

    @Size(max = 15)
    @NotEmpty
    private LocalDate dataAgendamento;

    @Size(max = 15)
    @NotEmpty
    private LocalDate dataConsulta;

    @Size(max = 30)
    @NotEmpty
    private StatusDoAgendamento statusConsulta;

}
