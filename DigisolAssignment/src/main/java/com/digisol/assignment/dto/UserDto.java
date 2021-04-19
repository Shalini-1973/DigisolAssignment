package com.digisol.assignment.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	int id;
	String name;
	String email;
	Set<AddressDto> addressDto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Set<AddressDto> getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(Set<AddressDto> addressDto) {
		this.addressDto = addressDto;
	}

}
