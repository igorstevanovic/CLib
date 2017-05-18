package hm.ctlib.dto;


public class LibrarianDTO extends PersonDTO {

	private RoleDTO roleDTO;
	
	public LibrarianDTO() {
		
	}
	
	public LibrarianDTO(Integer id, String firstName, String lastName,
			String email, Boolean active, RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	@Override
	public String toString() {
		return "LibrarianDTO [roleDTO=" + roleDTO + ", id=" + id
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", active="
				+ active + "]";
	}
	
}
