package hm.ctlib.service.impl;

import hm.ctlib.model.Role;
import hm.ctlib.repository.RoleRepository;
import hm.ctlib.service.RoleService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class JpaRoleService implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

	@Override
	public Role findOne(Integer id) {
		
		return roleRepository.findOne(id);
	}

	@Override
	public Role saveRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void deleteRole(Integer id) {

		roleRepository.delete(id);

	}

}
