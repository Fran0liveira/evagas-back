package com.ksoft.evagas_back.domain.usuario;

public enum Role {
	
	EMPTY("EMPTY", ""),
	ADMIN("ADMIN", "A"),
	RECRUTADOR("RECRUTADOR", "R"),
	CANDIDATO("CANDIDATO", "C");
	
	private final String role;
	private final String code;
	
	Role(String role, String code){
		this.role = role;
		this.code = code;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getCode() {
		return code;
	}
	
	public static Role fromCode(String code) {
		for (Role role : Role.values()) {
	        if (role.getCode().equals(code)) {
	            return role;
	        }
	    }
	    throw new IllegalArgumentException("Código inválido para Role: " + code);
	}

}
