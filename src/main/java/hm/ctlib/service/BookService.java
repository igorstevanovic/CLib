package hm.ctlib.service;

import hm.ctlib.model.Book;

import java.util.List;

public interface BookService {
	List<Book> findAll();

	Book findOne(Integer id);

	Book save(Book book);

	void delete(Integer id);

	List<Book> findByAuthorId(Integer id);
}
