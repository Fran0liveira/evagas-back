package com.ksoft.evagas_back.domain.usuario;

import com.ksoft.evagas_back.domain.vagas.VagaDto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UsuarioDto {
	
	private Long id;
	private String nome;
	private String sobrenome;
	
	public Usuario toUsuario() {
		
		return new Usuario()
				.setId(id)
				.setNome(nome)
				.setSobrenome(sobrenome);
		
	}

}
