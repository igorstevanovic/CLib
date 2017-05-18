package hm.ctlib.support;

import hm.ctlib.dto.AuthorDTO;
import hm.ctlib.model.Author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorDTO implements Converter<Author, AuthorDTO> {

	@Override
	public AuthorDTO convert(Author author) {

		return new AuthorDTO(author.getId(), author.getFirstName(),
				author.getLastName(), author.getFirstName() + " "
						+ author.getLastName());
	}

	public List<AuthorDTO> convert(List<Author> authors) {
		List<AuthorDTO> retVal = new ArrayList<>();
		for (Author author : authors) {
			retVal.add(convert(author));
		}
		return retVal;
	}

}
