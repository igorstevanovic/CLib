package hm.ctlib.support;

import hm.ctlib.dto.RoleDTO;
import hm.ctlib.model.Role;
import hm.ctlib.service.LibrarianService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleDTOToRole implements Converter<RoleDTO, Role> {

	@Autowired
	LibrarianService librarianService;

	@Override
	public Role convert(RoleDTO roleDTO) {
		// TODO Auto-generated method stub
		return new Role(roleDTO.getId(), roleDTO.getAuthority(),
				librarianService.findByRoleId(roleDTO.getId()));
	}

}
