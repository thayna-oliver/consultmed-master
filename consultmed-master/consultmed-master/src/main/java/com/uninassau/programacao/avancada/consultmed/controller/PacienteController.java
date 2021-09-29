package com.uninassau.programacao.avancada.consultmed.controller;

import com.uninassau.programacao.avancada.consultmed.dto.PacienteDto;
import com.uninassau.programacao.avancada.consultmed.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultmed/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<PacienteDto> listAll(){
        return pacienteService.listAll();
    }

    @GetMapping("/{id}")
    public PacienteDto findById(@PathVariable Long id){
        return pacienteService.findById(id);
    }

    @PostMapping
    public PacienteDto save(@RequestBody PacienteDto pacienteDto){
        return pacienteService.save(pacienteDto);
    }

    @PutMapping("/{id}")
    public PacienteDto updateById(@PathVariable Long id, @RequestBody PacienteDto pacienteDto){
        return pacienteService.updateById(id, pacienteDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         pacienteService.DeleteById(id);
    }
}
