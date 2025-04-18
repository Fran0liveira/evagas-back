package com.ksoft.evagas_back.domain.usuario;

import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
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
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	@ElementCollection(targetClass = Role.class)
	@CollectionTable(
	        name = "tbuser_roles", 
	        joinColumns = @JoinColumn(name = "id")
	)
	@Column(name = "role_id")
	private List<Role> roles;
	
	public UsuarioDto toDto() {
		return new UsuarioDto()
				.setId(getId())
				.setNome(getNome())
				.setSobrenome(getSobrenome())
				.setEmail(getEmail())
				.setSenha(getSenha())
				.setRoles(roles);
	}

}
