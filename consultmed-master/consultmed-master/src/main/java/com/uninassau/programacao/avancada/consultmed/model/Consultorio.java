package com.uninassau.programacao.avancada.consultmed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
    private Endereco endereco;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false)
    private String cnpj;


}
