package com.uninassau.programacao.avancada.consultmed.controller;

import com.uninassau.programacao.avancada.consultmed.dto.EspecialidadeMedicaDto;
import com.uninassau.programacao.avancada.consultmed.service.EspecialidadeMedicaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultmed/v1/especialidades")
public class EspecialidadeMedicaController {

    @Autowired
    private EspecialidadeMedicaService especialidadeMedicaService;

    @GetMapping
    public List<EspecialidadeMedicaDto> listAll(){
        return especialidadeMedicaService.lisAll();
    }

    @GetMapping("/{id}")
    public EspecialidadeMedicaDto findById(@PathVariable Long id){
        return especialidadeMedicaService.findById(id);
    }

    @PostMapping
    public EspecialidadeMedicaDto save(@RequestBody EspecialidadeMedicaDto especialidadeMedicaDto){
        return especialidadeMedicaService.save(especialidadeMedicaDto);
    }

    @PutMapping("/{id}")
    public EspecialidadeMedicaDto updateById(@RequestBody EspecialidadeMedicaDto especialidadeMedicaDto,
                                             @PathVariable Long id){
        return especialidadeMedicaService.updateById(especialidadeMedicaDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        especialidadeMedicaService.deleteById(id);
    }
}
