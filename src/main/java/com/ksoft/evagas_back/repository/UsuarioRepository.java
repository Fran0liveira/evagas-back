package com.ksoft.evagas_back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksoft.evagas_back.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);

}
