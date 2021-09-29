package com.uninassau.programacao.avancada.consultmed.mapper;


import com.uninassau.programacao.avancada.consultmed.dto.FichaAgendamentoDto;
import com.uninassau.programacao.avancada.consultmed.model.FichaAgendamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FichaAgendamentoMapper {

    FichaAgendamentoMapper INSTANCE = Mappers.getMapper( FichaAgendamentoMapper.class);

    FichaAgendamento toModel(FichaAgendamentoDto fichaAgendamentoDto);

    FichaAgendamentoDto toDto (FichaAgendamento fichaAgendamento);



}
