package com.uninassau.programacao.avancada.consultmed.repository;

import com.uninassau.programacao.avancada.consultmed.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
