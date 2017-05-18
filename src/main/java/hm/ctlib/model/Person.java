package hm.ctlib.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.Email;

@MappedSuperclass
public class Person {
	
	@Id
	@Column(name="id")
	protected Integer id;
	@Column(name="firstName")
	protected String firstName;
	@Column(name="lastName")
	protected String lastName;
	@Column(name="email")
	@Email
	protected String email;
	@Column(name="password")
	protected String password;
	@Column(name="active")
	protected Boolean active;
	
	public Person(Integer id, String firstName, String lastName,
			String email, String password, Boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.active = active;
	}

	public Person() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
	
	
	
		
}
