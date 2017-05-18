package hm.ctlib.support;

import hm.ctlib.dto.LibrarianDTO;
import hm.ctlib.model.Librarian;
import hm.ctlib.service.LibrarianService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class LibrarianDTOToLibrarian implements
		Converter<LibrarianDTO, Librarian> {

	@Autowired
	RoleDTOToRole rDTO2r;

	LibrarianService librarianService;

	@Override
	public Librarian convert(LibrarianDTO librarianDTO) {

		return new Librarian(librarianDTO.getId(), librarianDTO.getFirstName(),
				librarianDTO.getLastName(), librarianDTO.getEmail(),
				librarianService.findOne(librarianDTO.getId()).getPassword(),
				librarianDTO.getActive(), rDTO2r.convert(librarianDTO
						.getRoleDTO()));
	}

}
