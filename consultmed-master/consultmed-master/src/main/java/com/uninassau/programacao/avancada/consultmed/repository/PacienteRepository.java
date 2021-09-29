package com.uninassau.programacao.avancada.consultmed.repository;

import com.uninassau.programacao.avancada.consultmed.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
