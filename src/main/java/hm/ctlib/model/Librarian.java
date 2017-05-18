package hm.ctlib.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblLibrarian")
public class Librarian extends Person {

	@ManyToOne(fetch=FetchType.LAZY)
	private Role role;
	 
	public Librarian(Integer id, String firstName, String lastName,
			String email, String password, Boolean active, Role role) {
		super(id, firstName, lastName, email, password, active);
		this.role = role;
	}

	

	public Librarian() {
		// TODO Auto-generated constructor stub
	}



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
