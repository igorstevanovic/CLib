package hm.ctlib.controller;

import java.util.ArrayList;
import java.util.List;

import hm.ctlib.dto.LibrarianDTO;
import hm.ctlib.model.Librarian;
import hm.ctlib.service.LibrarianService;
import hm.ctlib.support.LibrarianToLibrarianDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/librarians")
public class ApiLibrarianController {

	@Autowired
	LibrarianService librarianService;
	
	@Autowired
	LibrarianToLibrarianDTO l2lDTO;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<LibrarianDTO>> getLibrarians(){
		List <Librarian> librarians = new ArrayList<>();
		librarians = librarianService.findAll();
		List<LibrarianDTO> libDTO = l2lDTO.convert(librarians);
		return new ResponseEntity<>(libDTO, HttpStatus.OK);
	}
}
