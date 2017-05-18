package hm.ctlib.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.ctlib.model.Librarian;
import hm.ctlib.repository.LibrarianRepository;
import hm.ctlib.service.LibrarianService;


@Service
@Transactional
public class JpaLibrarianService implements LibrarianService {

	@Autowired
	LibrarianRepository librarianRepository;
	
	@Override
	public List<Librarian> findAll() {
		
		return librarianRepository.findAll();
	}

	@Override
	public Librarian findOne(Integer id) {
		
		return librarianRepository.findOne(id);
	}

	@Override
	public Librarian saveLibrarian(Librarian librarian) {
		
		return librarianRepository.save(librarian);
	}

	@Override
	public void deleteLibrarian(Integer id) {

		librarianRepository.delete(id);

	}

	@Override
	public List<Librarian> findByRoleId(Integer id) {
		
		return librarianRepository.findByRoleId(id);
	}

}
