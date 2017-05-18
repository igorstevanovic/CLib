package hm.ctlib.support;

import java.util.ArrayList;
import java.util.List;

import hm.ctlib.dto.LibrarianDTO;
import hm.ctlib.model.Librarian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LibrarianToLibrarianDTO implements
		Converter<Librarian, LibrarianDTO> {

	@Autowired
	RoleToTRoleDTO r2rDTO;

	@Override
	public LibrarianDTO convert(Librarian librarian) {
		System.out.println("Kobvertovanje librariana " + librarian.getFirstName());
		LibrarianDTO libDTO = new LibrarianDTO();
		libDTO.setId(librarian.getId());
		libDTO.setFirstName(librarian.getFirstName());
		libDTO.setLastName(librarian.getLastName());
		libDTO.setEmail(librarian.getEmail());
		libDTO.setActive(librarian.getActive());
		libDTO.setRoleDTO(r2rDTO.convert(librarian.getRole()));
		System.out.println("libDTO-1 " + libDTO);
		return libDTO;
	}

	public List<LibrarianDTO> convert(List<Librarian> librarians) {
		List<LibrarianDTO> retVal = new ArrayList<>();
		for (Librarian librarian : librarians) {
			LibrarianDTO libDTO = new LibrarianDTO();
			libDTO = convert(librarian);
			System.out.println("libDTO " + libDTO.getFirstName());
			retVal.add(libDTO);
		}
		return retVal;
	}

}
