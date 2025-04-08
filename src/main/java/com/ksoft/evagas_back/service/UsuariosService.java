package com.ksoft.evagas_back.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksoft.evagas_back.domain.usuario.Usuario;
import com.ksoft.evagas_back.domain.usuario.UsuarioDto;
import com.ksoft.evagas_back.domain.vagas.Vaga;
import com.ksoft.evagas_back.domain.vagas.VagaDto;
import com.ksoft.evagas_back.repository.UsuarioRepository;

@Service
public class UsuariosService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDto> getUsuarios(){
		
		return usuarioRepository
				.findAll()
				.stream()
				.map(u-> u.toDto())
				.collect(Collectors.toList());
	}
	
	public UsuarioDto salvarUsuario(UsuarioDto usuario) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario.toUsuario());
		return usuarioSalvo.toDto();
	}
	
	public UsuarioDto atualizarUsuario(UsuarioDto usuario) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario.toUsuario());
		return usuarioSalvo.toDto();
	}
	
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Optional<UsuarioDto> getUsuarioById(Long id) {
		Optional<Usuario> optUsuario = usuarioRepository.findById(id);
		if(!optUsuario.isPresent()) {
			return Optional.empty();
		}
		return Optional.of(optUsuario.get().toDto());
	}

}
