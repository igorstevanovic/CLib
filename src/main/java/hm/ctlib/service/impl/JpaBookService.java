package hm.ctlib.service.impl;

import hm.ctlib.model.Book;
import hm.ctlib.repository.BookRepository;
import hm.ctlib.service.BookService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JpaBookService implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> findAll() {

		return bookRepository.findAll();
	}

	@Override
	public Book save(Book book) {

		return bookRepository.save(book);
	}

	@Override
	public List<Book> findByAuthorId(Integer id) {

		return bookRepository.findByAuthorId(id);
	}

	@Override
	public Book findOne(Integer id) {
		
		return bookRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		bookRepository.delete(id);

	}

}
