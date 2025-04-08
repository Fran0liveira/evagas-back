package com.ksoft.evagas_back.domain.vagas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity(name = "tbvagas")
@Data
@Accessors(chain = true)
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "detalhes")
	private String detalhes;
	
	@Column(name = "empresa")
	private String empresa;
	
	public VagaDto toDto() {
		return new VagaDto()
		.setDescricao(getDescricao())
		.setDetalhes(getDetalhes())
		.setEmpresa(getEmpresa())
		.setId(getId());
	}
}
