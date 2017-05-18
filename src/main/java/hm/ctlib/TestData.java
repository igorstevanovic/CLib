package hm.ctlib;

import hm.ctlib.model.Author;
import hm.ctlib.model.Book;
import hm.ctlib.model.Librarian;
import hm.ctlib.model.Role;
import hm.ctlib.service.AuthorService;
import hm.ctlib.service.BookService;
import hm.ctlib.service.LibrarianService;
import hm.ctlib.service.RoleService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class TestData {

	@Autowired
	LibrarianService librarianService;

	@Autowired
	RoleService roleService;

	@Autowired
	AuthorService authorService;

	@Autowired
	BookService bookService;

	@PostConstruct
	public void init() {

		Role role = new Role();
		role.setAuthority("ROLE_ADMIN");

		roleService.saveRole(role);

		String password = "123";
		String cryptedPassword = new BCryptPasswordEncoder().encode(password);
		Librarian librarian = new Librarian();

		librarian.setFirstName("Igor");
		System.out.println(librarian.getFirstName());
		librarian.setLastName("Stevanovic");
		librarian.setEmail("stevanovic.igor@gmail.com");
		librarian.setPassword(cryptedPassword);
		librarian.setActive(true);
		librarian.setId(librarian.getEmail().hashCode());
		librarian.setRole(role);
		librarianService.saveLibrarian(librarian);

		password = "123";
		if (new BCryptPasswordEncoder().matches(password, librarianService
				.findOne(librarian.getId()).getPassword())) {
			System.out.println("Access granted");
		} else {
			System.out.println("Access denied");
		}

		Author author1 = new Author();
		author1.setFirstName("John");
		author1.setLastName("Grisham");
		author1.setId((author1.getFirstName() + author1.getLastName())
				.hashCode() & 0x7FFFFFFF);

		authorService.save(author1);

		Author author2 = new Author();
		author2.setFirstName("Agatha");
		author2.setLastName("Christie");
		author2.setId((author2.getFirstName() + author2.getLastName())
				.hashCode() & 0x7FFFFFFF);

		authorService.save(author2);

		Book book1 = new Book();
		book1.setAuthor(author1);
		book1.setIsbn("978-1784756963");
		book1.setTitle("The Firm");
		book1.setReserved(true);
		book1.setId(book1.getIsbn().hashCode() & 0x7FFFFFFF);
		bookService.save(book1);

		Book book2 = new Book();
		book2.setAuthor(author1);
		book2.setIsbn("978-0099590750");
		book2.setTitle("A Time To Kill");
		book2.setId(book2.getIsbn().hashCode() & 0x7FFFFFFF);
		bookService.save(book2);

		Book book3 = new Book();
		book3.setAuthor(author1);
		book3.setIsbn("978-0099537083");
		book3.setTitle("The Client");
		book3.setId(book3.getIsbn().hashCode() & 0x7FFFFFFF);
		bookService.save(book3);

		Book book4 = new Book();
		book4.setAuthor(author2);
		book4.setIsbn("978-0062073907");
		book4.setTitle("Murder in Mesopotamia");
		book4.setLent(true);
		book4.setId(book4.getIsbn().hashCode() & 0x7FFFFFFF);
		bookService.save(book4);

		Book book5 = new Book();
		book5.setAuthor(author2);
		book5.setIsbn("978-0062073556");
		book5.setTitle("Death on the Nile");
		book5.setId(book5.getIsbn().hashCode() & 0x7FFFFFFF);
		bookService.save(book5);

		Book book6 = new Book();
		book6.setAuthor(author2);
		book6.setIsbn("978-0062073587");
		book6.setTitle("The A. B. C. Murders");
		book6.setId(book6.getIsbn().hashCode() & 0x7FFFFFFF);
		bookService.save(book6);

		Book book7 = new Book();
		book7.setAuthor(author2);
		book7.setIsbn("978-0062073570");
		book7.setTitle("Five Little Pigs");
		book7.setId(book7.getIsbn().hashCode() & 0x7FFFFFFF);
		bookService.save(book7);

	}

}
