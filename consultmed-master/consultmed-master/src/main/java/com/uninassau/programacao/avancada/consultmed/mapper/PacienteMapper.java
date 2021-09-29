package com.uninassau.programacao.avancada.consultmed.mapper;

import com.uninassau.programacao.avancada.consultmed.dto.PacienteDto;
import com.uninassau.programacao.avancada.consultmed.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    Paciente toModel(PacienteDto pacienteDto);
    PacienteDto toDto(Paciente paciente);
}
