package hm.ctlib.dto;

public class RoleDTO {

	private Integer id;
	private String authority;

	public RoleDTO() {
		super();
	}

	public RoleDTO(Integer id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
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

}
