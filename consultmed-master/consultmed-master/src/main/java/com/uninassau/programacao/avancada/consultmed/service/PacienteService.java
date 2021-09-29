package com.uninassau.programacao.avancada.consultmed.service;

import com.uninassau.programacao.avancada.consultmed.dto.PacienteDto;
import com.uninassau.programacao.avancada.consultmed.mapper.PacienteMapper;
import com.uninassau.programacao.avancada.consultmed.model.Paciente;
import com.uninassau.programacao.avancada.consultmed.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    private PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;

    public List<PacienteDto> listAll(){
        List<Paciente> lista = pacienteRepository.findAll();

        return lista.stream()
                .map(pacienteMapper::toDto)
                .collect(Collectors.toList());
    }

    public PacienteDto findById(Long id){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Esse Id não existe"));

        return pacienteMapper.toDto(paciente);
    }

    public  PacienteDto save(PacienteDto pacienteDto){
        Paciente novoPaciente = pacienteMapper.toModel(pacienteDto);

        return pacienteMapper.toDto(pacienteRepository.save(novoPaciente));
    }

    public PacienteDto updateById(Long id, PacienteDto pacienteDto){
        if (pacienteRepository.existsById(id)){
            Paciente pacienteRecebido = pacienteMapper.toModel(pacienteDto);

            Paciente pacienteSalvo = pacienteRepository.save(pacienteRecebido);

            return pacienteMapper.toDto(pacienteSalvo);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse Id não existe");
        }
    }

    public void DeleteById(Long id){
        if (pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse Id não existe");
        }
    }

}
