package hm.ctlib.controller;

import hm.ctlib.dto.AuthorDTO;
import hm.ctlib.dto.BookDTO;
import hm.ctlib.model.Author;
import hm.ctlib.model.Book;
import hm.ctlib.service.AuthorService;
import hm.ctlib.service.BookService;
import hm.ctlib.support.AuthorDTOToAuthor;
import hm.ctlib.support.AuthorToAuthorDTO;
import hm.ctlib.support.BookToBookDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/authors")
public class ApiAuthorController {

	@Autowired
	AuthorService authorService;

	@Autowired
	BookService bookService;

	@Autowired
	AuthorToAuthorDTO a2aDTO;
	
	@Autowired
	AuthorDTOToAuthor aDTO2a;

	@Autowired
	BookToBookDTO b2bDTO;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<AuthorDTO>> getAuthors() {
		List<Author> authors;

		authors = authorService.findAll();

		return new ResponseEntity<>(a2aDTO.convert(authors), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<AuthorDTO> getAuthorsById(@PathVariable Integer id) {

		Author author = authorService.findOne(id);

		return new ResponseEntity<AuthorDTO>(a2aDTO.convert(author),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/books", method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable Integer id) {

		Author author = authorService.findOne(id);

		if (author == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		List<Book> foundBooks = bookService.findByAuthorId(id);

		return new ResponseEntity<>(b2bDTO.convert(foundBooks), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<Author> deleteAuthor(@PathVariable Integer id) {

		authorService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO newAuthorDTO) {

		Author savedAuthor = authorService.save(aDTO2a.convert(newAuthorDTO));

		return new ResponseEntity<>(a2aDTO.convert(savedAuthor), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<AuthorDTO> editAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable Integer id) {

		if (id != authorDTO.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Author savedAuthor = authorService.save(aDTO2a.convert(authorDTO));

		return new ResponseEntity<>(a2aDTO.convert(savedAuthor), HttpStatus.OK);
	}

}
