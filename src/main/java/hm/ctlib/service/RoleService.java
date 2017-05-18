package hm.ctlib.service;

import hm.ctlib.model.Role;

import java.util.List;

public interface RoleService {
	List<Role> findAll();
	Role findOne(Integer id);
	Role saveRole(Role role);
	void deleteRole(Integer id);
}
