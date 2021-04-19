package com.digisol.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digisol.assignment.dto.UpdateAddressDto;
import com.digisol.assignment.dto.UserAddressDto;
import com.digisol.assignment.dto.UserDto;
import com.digisol.assignment.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/addUserAndAddress")
	public UserDto addUserAndAddress(@RequestBody UserAddressDto userAddressDto) {
		
		UserDto userDto=userService.addUserAndAddress(userAddressDto);
		
		return userDto;
		
	}
	
	@PostMapping(value="/getUserByMobile")
	public ResponseEntity getUser(@RequestParam("Mobile") String mobile) {
		UserDto userDto = userService.getUserInfo(mobile);
		if(userDto!=null) {
			return ResponseEntity.ok(userDto);
		}
		return ResponseEntity.ok("No User Found");
	}
	
	@PostMapping(value="/getUserByAddress")
	public ResponseEntity getUserByAddress(@RequestParam("Address") String address) {
		List<UserDto> userDtos = userService.getUserByAddress(address);
		if(userDtos.size()==0) {
			return ResponseEntity.ok("No User Found");
		}
		return ResponseEntity.ok(userDtos);
	}
	
	@PostMapping(value="/updateAddress")
	public ResponseEntity updateAddress(@RequestBody UpdateAddressDto updateAddressDto) {
		UserDto updatedUserAddress = userService.updateAddress(updateAddressDto);
		if(updatedUserAddress!=null) {
			return ResponseEntity.ok(updatedUserAddress);
		}
		return ResponseEntity.ok("User not found");
	}
	
	
}
