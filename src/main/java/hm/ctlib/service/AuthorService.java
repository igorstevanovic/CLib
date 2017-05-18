package hm.ctlib.service;

import hm.ctlib.model.Author;

import java.util.List;


public interface AuthorService {
	List<Author> findAll();
	Author findOne(Integer id);
	Author save(Author author);
	void delete(Integer id);
}
