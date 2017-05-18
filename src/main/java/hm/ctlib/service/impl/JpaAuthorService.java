package hm.ctlib.service.impl;

import hm.ctlib.model.Author;
import hm.ctlib.repository.AuthorRepository;
import hm.ctlib.service.AuthorService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JpaAuthorService implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> findAll() {

		return authorRepository.findAll();
	}

	@Override
	public Author findOne(Integer id) {

		return authorRepository.findOne(id);
	}

	@Override
	public Author save(Author author) {

		return authorRepository.save(author);
	}

	@Override
	public void delete(Integer id) {

		authorRepository.delete(id);

	}

}
