package com.ksoft.evagas_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksoft.evagas_back.domain.vagas.Vaga;

public interface VagasRepository extends JpaRepository<Vaga, Long>
{

}
