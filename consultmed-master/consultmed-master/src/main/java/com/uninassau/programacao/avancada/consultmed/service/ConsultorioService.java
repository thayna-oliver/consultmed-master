package com.uninassau.programacao.avancada.consultmed.service;

import com.uninassau.programacao.avancada.consultmed.dto.ConsultorioDto;
import com.uninassau.programacao.avancada.consultmed.mapper.ConsultorioMapper;
import com.uninassau.programacao.avancada.consultmed.model.Consultorio;
import com.uninassau.programacao.avancada.consultmed.repository.ConsultorioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultorioService {

    @Autowired
    private ConsultorioRepository consultorioRepository;
    private final ConsultorioMapper consultorioMapper = ConsultorioMapper.INSTANCE;


    public List<ConsultorioDto> listAll() {
        List<Consultorio> todosConsultorio = consultorioRepository.findAll();
        return todosConsultorio.stream().map(consultorioMapper:: toDto).collect(Collectors.toList());
    }

    public ConsultorioDto findById(Long id){
       Consultorio consultorio = consultorioRepository.findById(id)
               .orElseThrow(()  -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID não Existe"));

       return consultorioMapper.toDto(consultorio);
   }

   public ConsultorioDto save(ConsultorioDto consultorioDto){
        Consultorio consultorio = consultorioMapper.toModel(consultorioDto);

        Consultorio consultorioSalvo = consultorioRepository.save(consultorio);
        return consultorioMapper.toDto(consultorioSalvo);
   }

   public ConsultorioDto updateById(ConsultorioDto consultorioDto, Long id){
        if(consultorioRepository.existsById(id)){
            Consultorio consultorioRebid = consultorioMapper.toModel(consultorioDto);
            Consultorio consultorioSalvo = consultorioRepository.save(consultorioRebid);

            return consultorioMapper.toDto(consultorioSalvo);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse ID não existe");
        }
   }

   public void deleteById(Long id){
        if(consultorioRepository.existsById(id)){
            consultorioRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse ID não existe");
        }
   }
}

