package hm.ctlib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblBooks")
public class Book {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "title")
	private String title;
	@Column(name = "reserved")
	private Boolean reserved = false;
	@Column(name = "lent")
	private Boolean lent = false;
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	
	
	public Book() {
		super();
	}

	public Book(Integer id, String isbn, String title,
			Author author) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;

	}
	
	public Book(Integer id, String isbn, String title, Boolean reserved,
			Boolean lent, Author author) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.reserved = reserved;
		this.lent = lent;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
