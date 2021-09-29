package com.uninassau.programacao.avancada.consultmed.service;

import com.uninassau.programacao.avancada.consultmed.dto.MedicoDto;
import com.uninassau.programacao.avancada.consultmed.mapper.MedicoMapper;
import com.uninassau.programacao.avancada.consultmed.model.Medico;
import com.uninassau.programacao.avancada.consultmed.model.Paciente;
import com.uninassau.programacao.avancada.consultmed.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    private MedicoMapper medicoMapper = MedicoMapper.INSTANCE;


    public List<MedicoDto> listAll(){
        List<Medico> lista = medicoRepository.findAll();

        return lista.stream().map(medicoMapper::toDto)
                .collect(Collectors.toList());
    }

    public MedicoDto findById(Long id){
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Este Id não existe"));

        return medicoMapper.toDto(medico);
    }

    public MedicoDto save(MedicoDto medicoDto){
        Medico novoMedico = medicoMapper.toModel(medicoDto);

        MedicoDto medicoDto1 = medicoMapper.toDto(medicoRepository.save(novoMedico));

        return medicoDto1;
    }

    public MedicoDto updateById(Long id, MedicoDto medicoDto){
        if (medicoRepository.existsById(id)){
            Medico medicoRecebido = medicoMapper.toModel(medicoDto);

            Medico medicoSalvo = medicoRepository.save(medicoRecebido);

            return medicoMapper.toDto(medicoSalvo);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Este id não existe");
        }
    }

    public void deleteById(Long id){
        medicoRepository.deleteById(id);
    }
}
