package com.ksoft.evagas_back.domain.vagas;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VagaDto{
	
	private Long id;
	private String descricao;
	private String detalhes;
	private String empresa;
	
	public Vaga toVaga(VagaDto dto) {
		return new Vaga()
				.setDescricao(dto.getDescricao())
				.setDetalhes(dto.getDetalhes())
				.setEmpresa(dto.getEmpresa())
				.setId(dto.getId());
	}
	


}
