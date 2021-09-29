package com.uninassau.programacao.avancada.consultmed.service;

import com.uninassau.programacao.avancada.consultmed.dto.EspecialidadeMedicaDto;
import com.uninassau.programacao.avancada.consultmed.mapper.EspecialidadeMedicaMapper;
import com.uninassau.programacao.avancada.consultmed.model.EspecialidadeMedica;
import com.uninassau.programacao.avancada.consultmed.repository.EspecialidadeMedicaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadeMedicaService {

    @Autowired
    private EspecialidadeMedicaRepository especialidadeMedicaRepository;

    private final EspecialidadeMedicaMapper especialidadeMedicaMapper = EspecialidadeMedicaMapper.INSTANCE;


    public List<EspecialidadeMedicaDto> lisAll(){
        List<EspecialidadeMedica> list = especialidadeMedicaRepository.findAll();

        return list.stream().map(especialidadeMedicaMapper::toDto).collect(Collectors.toList());
    }

    public EspecialidadeMedicaDto findById(Long id){
        EspecialidadeMedica especialidadeMedica = especialidadeMedicaRepository.findById(id)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "O ID não Existe"));

        return especialidadeMedicaMapper.toDto(especialidadeMedica);


    }

    public EspecialidadeMedicaDto save(EspecialidadeMedicaDto especialidadeMedicaDto){
        EspecialidadeMedica especialidadeMedica = especialidadeMedicaMapper.toModel(especialidadeMedicaDto);

        EspecialidadeMedica especialidadeMedicaSalva = especialidadeMedicaRepository.save(especialidadeMedica);

        return especialidadeMedicaMapper.toDto(especialidadeMedicaSalva);
    }

    public EspecialidadeMedicaDto updateById(EspecialidadeMedicaDto especialidadeMedicaDto, Long id){
        if(especialidadeMedicaRepository.existsById(id)){
            EspecialidadeMedica especialidadeMedicaRecebida = especialidadeMedicaMapper.toModel(especialidadeMedicaDto);

            EspecialidadeMedica especialidadeMedicaSalva = especialidadeMedicaRepository.save(especialidadeMedicaRecebida);

            return especialidadeMedicaMapper.toDto(especialidadeMedicaSalva);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse ID não existe");
        }
    }


    public void deleteById(Long id){
        if(especialidadeMedicaRepository.existsById(id)){
            especialidadeMedicaRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse ID não existe");
        }
    }


}
