package com.ksoft.evagas_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksoft.evagas_back.domain.vagas.Vaga;
import com.ksoft.evagas_back.domain.vagas.VagaDto;
import com.ksoft.evagas_back.service.VagasService;

@RestController
@RequestMapping("/vagas")
public class VagasController {
	
	@Autowired
	private VagasService vagasService;
	
	@GetMapping
	public ResponseEntity<?> getVagas()
	{
		List<VagaDto> vagas = vagasService.getVagas();
		return ResponseEntity.ok(vagas);
	}
	
	@PostMapping
	public ResponseEntity<?> salvarVaga(@RequestBody VagaDto vaga)
	{
		VagaDto vagaSalva = vagasService.salvarVaga(vaga);
		return ResponseEntity.ok(vagaSalva);
	}
	
	@PutMapping
	public ResponseEntity<?> updateVaga(@RequestBody VagaDto vaga)
	{
		VagaDto vagaSalva = vagasService.updateVaga(vaga);
		return ResponseEntity.ok(vagaSalva);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVaga(@PathVariable("id") Long id)
	{
		vagasService.deleteVaga(id);
		return ResponseEntity.noContent().build();
	}

}
