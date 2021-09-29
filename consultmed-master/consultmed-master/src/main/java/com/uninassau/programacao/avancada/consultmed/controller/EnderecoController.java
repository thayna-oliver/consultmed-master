package com.uninassau.programacao.avancada.consultmed.controller;
import com.uninassau.programacao.avancada.consultmed.dto.EnderecoDto;
import com.uninassau.programacao.avancada.consultmed.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultmed/v1/enderecos")
@RequiredArgsConstructor
public class EnderecoController {


    private final EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDto> listAll(){
        return enderecoService.listAll();
    }


    @GetMapping("/{id}")
    public EnderecoDto findById(@PathVariable Long id){
        return enderecoService.findById(id);
    }

    @PostMapping
    public EnderecoDto save(@RequestBody EnderecoDto enderecoDto){
        return enderecoService.save(enderecoDto);
    }

    @PutMapping("/{id}")
    public EnderecoDto updateById(@PathVariable Long id, @RequestBody EnderecoDto enderecoDto){
        return enderecoService.updateById(enderecoDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        enderecoService.deleteById(id);
    }
}
