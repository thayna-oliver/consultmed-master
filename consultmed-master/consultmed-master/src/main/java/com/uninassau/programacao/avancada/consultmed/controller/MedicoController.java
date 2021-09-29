package com.uninassau.programacao.avancada.consultmed.controller;

import com.uninassau.programacao.avancada.consultmed.dto.MedicoDto;
import com.uninassau.programacao.avancada.consultmed.model.Medico;
import com.uninassau.programacao.avancada.consultmed.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultmed/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<MedicoDto> listAll(){
        return medicoService.listAll();
    }

    @GetMapping("/{id}")
    public MedicoDto findById(@PathVariable Long id){
        return medicoService.findById(id);
    }

    @PostMapping
    public  MedicoDto save(@RequestBody MedicoDto medicoDto){
        return medicoService.save(medicoDto);
    }

    @PutMapping("/{id}")
    public MedicoDto updateById(@PathVariable Long id, @RequestBody MedicoDto medicoDto){
        return medicoService.updateById(id, medicoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        medicoService.deleteById(id);
    }
}
