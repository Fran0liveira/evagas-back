package com.ksoft.evagas_back.infra.converter;

import com.ksoft.evagas_back.domain.usuario.Role;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

	@Override
	public String convertToDatabaseColumn(Role role) {
		if (role == null) {
            return null;
        }
        return role.getCode();
	}

	@Override
	public Role convertToEntityAttribute(String dbData) {
		if (dbData == null) {
            return null;
        }
        return Role.fromCode(dbData);
	}

}
