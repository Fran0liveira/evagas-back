package com.ksoft.evagas_back.service;

import java.util.List;
import java.util.Optional;
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
	
	public Optional<VagaDto> getVagaById(Long id) {
		Optional<Vaga> optVaga = vagasRepository.findById(id);
		if(!optVaga.isPresent()) {
			return Optional.empty();
		}
		return Optional.of(optVaga.get().toDto());
	}
}
