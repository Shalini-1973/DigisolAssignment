package com.digisol.assignment.dto;

public class UpdateAddressDto {

	private String name;
	private String mobile;
	private String email;
	private String previous_address;
	private String previous_pincode;

	private String new_address;
	private String new_pincode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrevious_address() {
		return previous_address;
	}

	public void setPrevious_address(String previous_address) {
		this.previous_address = previous_address;
	}

	public String getPrevious_pincode() {
		return previous_pincode;
	}

	public void setPrevious_pincode(String previous_pincode) {
		this.previous_pincode = previous_pincode;
	}

	public String getNew_address() {
		return new_address;
	}

	public void setNew_address(String new_address) {
		this.new_address = new_address;
	}

	public String getNew_pincode() {
		return new_pincode;
	}

	public void setNew_pincode(String new_pincode) {
		this.new_pincode = new_pincode;
	}

}
