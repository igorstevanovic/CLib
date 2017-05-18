package hm.ctlib.service;

import hm.ctlib.model.Librarian;

import java.util.List;

public interface LibrarianService {
	List<Librarian> findAll();
	Librarian findOne(Integer id);
	Librarian saveLibrarian(Librarian librarian);
	void deleteLibrarian(Integer id);
	
	List<Librarian> findByRoleId(Integer id);
	
}
