package com.digisol.assignment.utility;

import java.util.HashSet;
import java.util.Set;

import com.digisol.assignment.dto.AddressDto;
import com.digisol.assignment.dto.UserDto;
import com.digisol.assignment.entity.Address;
import com.digisol.assignment.entity.User;

public class UserUtility {

	public static UserDto copyToUserDto(User saved) {
		
		UserDto userDto = new UserDto();
		userDto.setId(saved.getId());
		userDto.setName(saved.getName());
		userDto.setEmail(saved.getEmail());
		Set<Address> savedAddresses = saved.getAddress();
		
		Set<AddressDto> addressDto = new HashSet<>();
		
		for(Address address : savedAddresses) {
			AddressDto newAddressDto = new AddressDto();
			newAddressDto.setAddress(address.getAddress());
			newAddressDto.setPincode(address.getPincode());
			addressDto.add(newAddressDto);
		}
		userDto.setAddressDto(addressDto);
		return userDto;
		
	}

	public static UserDto copyToUserDtoOfAddress(User saved, String address) {
		UserDto userDto = new UserDto();
		userDto.setId(saved.getId());
		userDto.setName(saved.getName());
		userDto.setEmail(saved.getEmail());
		Set<Address> savedAddresses = saved.getAddress();
		
		Set<AddressDto> addressDto = new HashSet<>();
		
		for(Address addr : savedAddresses) {
			if(addr.getAddress().toLowerCase().contains(address.toLowerCase())) {
			AddressDto newAddressDto = new AddressDto();
			newAddressDto.setAddress(addr.getAddress());
			newAddressDto.setPincode(addr.getPincode());
			addressDto.add(newAddressDto);
			}
		}
		userDto.setAddressDto(addressDto);
		return userDto;
	}
	
	
	

}
