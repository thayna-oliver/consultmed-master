package com.uninassau.programacao.avancada.consultmed.service;

import com.uninassau.programacao.avancada.consultmed.dto.EnderecoDto;
import com.uninassau.programacao.avancada.consultmed.mapper.EnderecoMapper;
import com.uninassau.programacao.avancada.consultmed.model.Endereco;
import com.uninassau.programacao.avancada.consultmed.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper = EnderecoMapper.INSTANCE;


    public List<EnderecoDto> listAll(){
        List<Endereco> todosEndereco = enderecoRepository.findAll();
        return todosEndereco.stream().map(enderecoMapper::toDto)
                .collect(Collectors.toList());
    }

    public EnderecoDto findById(Long id){
        return verifyIfExists(id);
    }

    public EnderecoDto save(EnderecoDto enderecoDto){
        Endereco enderecoRecebido = enderecoMapper.toModel(enderecoDto);

        return enderecoMapper.toDto(enderecoRepository.save(enderecoRecebido));
    }

    public EnderecoDto updateById(EnderecoDto enderecoDto, Long id){
        verifyIfExists(id);

        Endereco enderecoAtualizado = enderecoRepository.save(enderecoMapper.toModel(enderecoDto));

        return enderecoMapper.toDto(enderecoAtualizado);

    }

    public void deleteById(Long id){
        verifyIfExists(id);
        enderecoRepository.deleteById(id);
    }


    private EnderecoDto verifyIfExists(Long id){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "O ID não Existe"));

        return enderecoMapper.toDto(endereco);
    }


}
