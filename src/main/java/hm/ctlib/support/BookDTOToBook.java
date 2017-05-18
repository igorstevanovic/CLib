package hm.ctlib.support;

import hm.ctlib.dto.BookDTO;
import hm.ctlib.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookDTOToBook implements Converter<BookDTO, Book> {

	@Autowired
	AuthorDTOToAuthor aDTO2a;

	@Override
	public Book convert(BookDTO bookDTO) {
		return new Book(bookDTO.getId(), bookDTO.getIsbn(), bookDTO.getTitle(),
				bookDTO.getReserved(), bookDTO.getLent(), aDTO2a.convert(bookDTO.getAuthorDTO()));
	}

}
