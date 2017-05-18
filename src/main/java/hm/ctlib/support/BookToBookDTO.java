package hm.ctlib.support;

import hm.ctlib.dto.BookDTO;
import hm.ctlib.model.Book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDTO implements Converter<Book, BookDTO> {

	@Autowired
	AuthorToAuthorDTO a2aDTO;

	@Override
	public BookDTO convert(Book book) {

		return new BookDTO(book.getId(), book.getIsbn(), book.getTitle(),
				book.getReserved(), book.getLent(), a2aDTO.convert(book
						.getAuthor()));
	}

	public List<BookDTO> convert(List<Book> books) {
		List<BookDTO> retVal = new ArrayList<>();
		for (Book book : books) {
			retVal.add(convert(book));
		}
		return retVal;
	}

}
