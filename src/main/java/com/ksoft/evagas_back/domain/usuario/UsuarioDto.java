package com.ksoft.evagas_back.domain.usuario;

import java.util.List;

import com.ksoft.evagas_back.domain.vagas.VagaDto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UsuarioDto {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String senha;
	private String email;
	private List<Role> roles;
	
	public Usuario toUsuario() {
		
		return new Usuario()
				.setId(id)
				.setNome(nome)
				.setSobrenome(sobrenome)
				.setEmail(email)
				.setSenha(senha)
				.setRoles(roles);
		
	}

}
