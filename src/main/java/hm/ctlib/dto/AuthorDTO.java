package hm.ctlib.dto;

public class AuthorDTO {

	private Integer id;
	private String firstName;
	private String lastName;
	private String name;

	public AuthorDTO() {
		super();
	}

	public AuthorDTO(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public AuthorDTO(Integer id, String firstName, String lastName,String name) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
	}

	public AuthorDTO(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
