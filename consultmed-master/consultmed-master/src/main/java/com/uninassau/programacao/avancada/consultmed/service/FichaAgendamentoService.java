package com.uninassau.programacao.avancada.consultmed.service;

import com.uninassau.programacao.avancada.consultmed.dto.FichaAgendamentoDto;
import com.uninassau.programacao.avancada.consultmed.mapper.FichaAgendamentoMapper;
import com.uninassau.programacao.avancada.consultmed.model.FichaAgendamento;
import com.uninassau.programacao.avancada.consultmed.repository.FichaAgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FichaAgendamentoService {

    @Autowired
    private FichaAgendamentoRepository fichaAgendamentoRepository;
    private final FichaAgendamentoMapper fichaAgendamentoMapper = FichaAgendamentoMapper.INSTANCE;


    public List<FichaAgendamentoDto> listAll() {
        List<FichaAgendamento> todosAgendamentos = fichaAgendamentoRepository.findAll();
        return todosAgendamentos.stream().map(fichaAgendamentoMapper::toDto)
                .collect(Collectors.toList());

    }

    public FichaAgendamentoDto findById(Long id) {
        FichaAgendamento fichaAgendamento = fichaAgendamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Nenhum agendamento encontrado!" ));

        return fichaAgendamentoMapper.toDto(fichaAgendamento);

    }

    public FichaAgendamentoDto save (FichaAgendamentoDto fichaAgendamentoDto){
        FichaAgendamento fichaAgendamento = fichaAgendamentoMapper.toModel(fichaAgendamentoDto);

        FichaAgendamento agendamentoSalvo = fichaAgendamentoRepository.save(fichaAgendamento);

        return fichaAgendamentoMapper.toDto(agendamentoSalvo);

    }

    public FichaAgendamentoDto updateById (FichaAgendamentoDto fichaAgendamentoDto, Long id){
        if (fichaAgendamentoRepository.existsById(id)) {
            FichaAgendamento fichaAgendamentoRecebida = fichaAgendamentoMapper.toModel(fichaAgendamentoDto);

            FichaAgendamento fichaAgendamentoSalva = fichaAgendamentoRepository.save(fichaAgendamentoRecebida);

            return fichaAgendamentoMapper.toDto(fichaAgendamentoSalva);
        }else{
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Nenhum agendamento encontrado!" );
        }
    }

    public void deleteById(Long id) {
        if (fichaAgendamentoRepository.existsById(id)) {
            fichaAgendamentoRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nenhum agendamento encontrado!" );
        }
    }

    private FichaAgendamentoDto verifyIfExists(Long id) {
        FichaAgendamento fichaAgendamento = fichaAgendamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Nenhum agendamento encontrado!" ));

        return fichaAgendamentoMapper.toDto( fichaAgendamento );
    }

}