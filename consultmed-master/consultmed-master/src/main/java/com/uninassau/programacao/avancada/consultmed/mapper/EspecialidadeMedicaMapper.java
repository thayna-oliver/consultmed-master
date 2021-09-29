package com.uninassau.programacao.avancada.consultmed.mapper;

import com.uninassau.programacao.avancada.consultmed.dto.EspecialidadeMedicaDto;
import com.uninassau.programacao.avancada.consultmed.model.EspecialidadeMedica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EspecialidadeMedicaMapper {
    EspecialidadeMedicaMapper INSTANCE = Mappers.getMapper(EspecialidadeMedicaMapper.class);

    EspecialidadeMedica toModel(EspecialidadeMedicaDto especialidadeMedicaDto);
    EspecialidadeMedicaDto toDto(EspecialidadeMedica especialidadeMedica);
}
