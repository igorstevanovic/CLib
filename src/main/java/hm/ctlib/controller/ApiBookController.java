package hm.ctlib.controller;

import hm.ctlib.dto.BookDTO;
import hm.ctlib.model.Book;
import hm.ctlib.service.BookService;
import hm.ctlib.support.BookDTOToBook;
import hm.ctlib.support.BookToBookDTO;

import java.util.ArrayList;
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
@RequestMapping(value = "/api/books")
public class ApiBookController {

	@Autowired
	BookToBookDTO b2bDTO;

	@Autowired
	BookDTOToBook bDTO2b;

	@Autowired
	BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBooks(/*
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "priceFrom", defaultValue = "0") int priceFrom,
			@RequestParam(value = "priceTo", defaultValue = Integer.MAX_VALUE
					+ "") int priceTo,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "vpp", defaultValue="10") int size,
			@RequestParam(value = "genre", required = false) Long genreId*/) {

		
//		Page<Dvd> dvds;
		List<Book> books = new ArrayList<>();
		books = bookService.findAll(/*page, size*/);
		/*if (title != null) {
			dvds = bookService
					.findTitle(title, priceFrom, priceTo, page, size);
			
		} else {
			dvds = bookService.findPrice(priceFrom, priceTo, page, size);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", dvds.getTotalPages()+"");
		*/
		
		
		
		return new ResponseEntity<>(b2bDTO.convert(books/*.getContent()), headers*/), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<BookDTO> getBooksById(@PathVariable Integer id) {
		Book book = bookService.findOne(id);
		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(b2bDTO.convert(book), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BookDTO> addBook(
			@RequestBody BookDTO newBookDTO) {

		Book savedBook = bookService.save(bDTO2b
				.convert(newBookDTO));

		return new ResponseEntity<>(b2bDTO.convert(savedBook),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<Book> deleteBook(@PathVariable Integer id) {
		bookService.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<BookDTO> editBook(
			@RequestBody BookDTO bookDTO, @PathVariable Integer id) {

		if (id != bookDTO.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Book persisted = bookService.save(bDTO2b
				.convert(bookDTO));

		return new ResponseEntity<>(b2bDTO.convert(persisted), HttpStatus.OK);
	}
	
}
