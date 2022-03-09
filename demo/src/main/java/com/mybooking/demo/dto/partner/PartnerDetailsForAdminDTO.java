package com.mybooking.demo.dto.partner;

public class PartnerDetailsForAdminDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Integer type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public PartnerDetailsForAdminDTO(Long id, String firstName, String lastName, String email, Integer type) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
	}

	public PartnerDetailsForAdminDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PartnerDetailsForAdminDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", type=" + type + "]";
	}

}
