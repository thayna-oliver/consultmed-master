package com.uninassau.programacao.avancada.consultmed.mapper;

import com.uninassau.programacao.avancada.consultmed.dto.ConsultorioDto;
import com.uninassau.programacao.avancada.consultmed.model.Consultorio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsultorioMapper {
    ConsultorioMapper INSTANCE = Mappers.getMapper(ConsultorioMapper.class);

    Consultorio toModel(ConsultorioDto consultorioDto);
    ConsultorioDto toDto(Consultorio consultorio);
}


