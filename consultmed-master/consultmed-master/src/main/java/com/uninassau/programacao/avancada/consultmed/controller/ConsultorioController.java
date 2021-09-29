package com.uninassau.programacao.avancada.consultmed.controller;

import com.uninassau.programacao.avancada.consultmed.dto.ConsultorioDto;
import com.uninassau.programacao.avancada.consultmed.service.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultmed/v1/consultorios")
public class ConsultorioController {

    @Autowired
    private ConsultorioService consultorioService;

    @GetMapping
    public List<ConsultorioDto> listAll(){
        return consultorioService.listAll(); }

    @GetMapping("/{id}")
    public ConsultorioDto findById(@PathVariable Long id){return consultorioService.findById(id);}

    @PostMapping
    public ConsultorioDto save(@RequestBody ConsultorioDto consultorioDto){
        return consultorioService.save(consultorioDto);
    }
    @PutMapping("/{id}")
    public ConsultorioDto updateByid(@RequestBody ConsultorioDto consultorioDto, @PathVariable Long id){
        return consultorioService.updateById(consultorioDto, id);
    }

    @DeleteMapping("/{id}")
    public void deteleById(@PathVariable Long id){consultorioService.deleteById(id);}
}
