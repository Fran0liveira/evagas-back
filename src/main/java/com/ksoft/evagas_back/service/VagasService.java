package com.ksoft.evagas_back.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksoft.evagas_back.domain.vagas.Vaga;
import com.ksoft.evagas_back.domain.vagas.VagaDto;
import com.ksoft.evagas_back.repository.VagasRepository;

@Service
public class VagasService {
	
	@Autowired
	private VagasRepository vagasRepository;
	
	public List<VagaDto> getVagas()
	{
		System.out.println("CriANDO BRaNCH dev");
		return vagasRepository.findAll()
				.stream()
				.map(v-> v.toDto()
				).collect(Collectors.toList());
	}
	
	public VagaDto salvarVaga(VagaDto vagaDto) 
	{
		Vaga vaga = vagasRepository.save(vagaDto.toVaga(vagaDto));
		return vaga.toDto();
	}
	
	public VagaDto updateVaga(VagaDto vagaDto) 
	{
		Vaga vaga = vagasRepository.save(vagaDto.toVaga(vagaDto));
		return vaga.toDto();
	}
	
	public void deleteVaga(Long idVaga) 
	{
		vagasRepository.deleteById(idVaga);
	}
	
	

}
