package hm.ctlib.support;

import hm.ctlib.dto.AuthorDTO;
import hm.ctlib.model.Author;
import hm.ctlib.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOToAuthor implements Converter<AuthorDTO, Author> {

	@Autowired
	BookService bookService;

	@Override
	public Author convert(AuthorDTO authorDTO) {

		return new Author(authorDTO.getId(), authorDTO.getFirstName(),
				authorDTO.getLastName(), bookService.findByAuthorId(authorDTO
						.getId()));
	}

}
