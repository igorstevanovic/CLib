package hm.ctlib.support;

import hm.ctlib.dto.RoleDTO;
import hm.ctlib.model.Role;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToTRoleDTO implements Converter<Role, RoleDTO>{

	@Override
	public RoleDTO convert(Role role) {
		return new RoleDTO(role.getId(), role.getAuthority());
	}
	
}
