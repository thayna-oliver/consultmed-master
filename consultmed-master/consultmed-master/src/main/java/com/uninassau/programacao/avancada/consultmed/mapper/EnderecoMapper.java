package com.uninassau.programacao.avancada.consultmed.mapper;

import com.uninassau.programacao.avancada.consultmed.dto.EnderecoDto;
import com.uninassau.programacao.avancada.consultmed.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    Endereco toModel(EnderecoDto enderecoDto);

    EnderecoDto toDto(Endereco endereco);
}
