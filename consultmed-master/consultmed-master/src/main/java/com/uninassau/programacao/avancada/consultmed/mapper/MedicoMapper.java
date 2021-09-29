package com.uninassau.programacao.avancada.consultmed.mapper;

import com.uninassau.programacao.avancada.consultmed.dto.MedicoDto;
import com.uninassau.programacao.avancada.consultmed.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface MedicoMapper {
    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    Medico toModel(MedicoDto medicoDto);

    MedicoDto toDto(Medico medico);
}
