package hm.ctlib.dto;

public class BookDTO {
	private Integer id;
	private String isbn;
	private String title;
	private Boolean reserved;
	private Boolean lent;
	private AuthorDTO authorDTO;

	public BookDTO() {
		super();
	}

	public BookDTO(Integer id, String isbn, String title, Boolean reserved,
			Boolean lent, AuthorDTO authorDTO) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.reserved = reserved;
		this.lent = lent;
		this.authorDTO = authorDTO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AuthorDTO getAuthorDTO() {
		return authorDTO;
	}

	public void setAuthorDTO(AuthorDTO authorDTO) {
		this.authorDTO = authorDTO;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	public Boolean getLent() {
		return lent;
	}

	public void setLent(Boolean lent) {
		this.lent = lent;
	}

}
