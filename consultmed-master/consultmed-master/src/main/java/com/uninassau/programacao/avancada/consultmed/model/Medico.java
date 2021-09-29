package com.uninassau.programacao.avancada.consultmed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
    private Endereco endereco;
    private String telefone;
    private String crm;
    @ManyToOne
    private EspecialidadeMedica especialidadeMedica;
}
