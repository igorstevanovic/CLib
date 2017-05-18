package hm.ctlib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblRoles")
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="authority")
	private String authority;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
	private List<Librarian> librarians = new ArrayList<>();

	public Role() {
		super();
	}

	public Role(Integer id, String authority, List<Librarian> librarians) {
		super();
		this.id = id;
		this.authority = authority;
		this.librarians = librarians;
	}



		public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public List<Librarian> getLibrarians() {
		return librarians;
	}

	public void setLibrarians(List<Librarian> librarians) {
		this.librarians = librarians;
	}
	
	
	
	
}
