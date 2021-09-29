package com.uninassau.programacao.avancada.consultmed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FichaAgendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;


    @ManyToOne
    private Medico medico;

    @ManyToOne
    private EspecialidadeMedica especialidade;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Consultorio Consultorio;

    @Column(nullable = false)
    private LocalDate dataAgendamento;

    @Column(nullable = false)
    private LocalDate dataConsulta;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDoAgendamento statusConsulta;


}
