package com.ksoft.evagas_back.domain.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity(name = "tbusuario")
@Data
@Accessors(chain = true)
public class Usuario {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	public UsuarioDto toDto() {
		return new UsuarioDto()
				.setId(getId())
				.setNome(getNome())
				.setSobrenome(getSobrenome());
	}

}
