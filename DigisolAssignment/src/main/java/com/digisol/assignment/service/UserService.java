package com.digisol.assignment.service;

import java.util.List;

import com.digisol.assignment.dto.UpdateAddressDto;
import com.digisol.assignment.dto.UserAddressDto;
import com.digisol.assignment.dto.UserDto;

public interface UserService {

	UserDto addUserAndAddress(UserAddressDto userAddressDto);

	UserDto getUserInfo(String mobile);

	List<UserDto> getUserByAddress(String address);

	UserDto updateAddress(UpdateAddressDto updateAddressDto);
	
	

}
