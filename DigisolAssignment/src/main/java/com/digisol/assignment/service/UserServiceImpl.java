package com.digisol.assignment.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digisol.assignment.dto.UpdateAddressDto;
import com.digisol.assignment.dto.UserAddressDto;
import com.digisol.assignment.dto.UserDto;
import com.digisol.assignment.entity.Address;
import com.digisol.assignment.entity.User;
import com.digisol.assignment.repository.AddressRepository;
import com.digisol.assignment.repository.UserRepository;
import com.digisol.assignment.utility.UserUtility;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public UserDto addUserAndAddress(UserAddressDto userAddressDto) {
		
		User existUser = userRepository.findByMobile(userAddressDto.getMobile());
		if(existUser==null) {
			User newUser = new User();
			newUser.setName(userAddressDto.getName());
			newUser.setEmail(userAddressDto.getEmail());
			newUser.setMobile(userAddressDto.getMobile());	
			Address newAddress = new Address();
			newAddress.setAddress(userAddressDto.getAddress());
			newAddress.setPincode(userAddressDto.getPincode());
			newAddress.setUser(newUser);
			Set<Address> addresses = new HashSet<>();
			addresses.add(newAddress);
			newUser.setAddress(addresses);
			User saved = userRepository.save(newUser);
			addressRepository.save(newAddress);
			UserDto userDto = UserUtility.copyToUserDto(saved);
			return userDto;
			
		}else {
			Address newAddress = new Address();
			newAddress.setAddress(userAddressDto.getAddress());
			newAddress.setPincode(userAddressDto.getPincode());
			newAddress.setUser(existUser);
			Set<Address> addresses = existUser.getAddress();
			addresses.add(newAddress);
			userRepository.save(existUser);
			addressRepository.save(newAddress);
			UserDto userDto = UserUtility.copyToUserDto(existUser);
			return userDto;
			
		}
	}

	@Override
	public UserDto getUserInfo(String mobile) {
		
		User user = userRepository.findByMobile(mobile);
		if(user!=null) {
			UserDto userDto = UserUtility.copyToUserDto(user);
			return userDto; 
		}
		return null;
	}

	@Override
	public List<UserDto> getUserByAddress(String address) {
		
		List<Address> addresses = addressRepository.findByAddress(address);
		Set<User> userSet = new HashSet<>();
		for(Address add : addresses) {
			userSet.add(add.getUser());
		}
		
		List<UserDto> list = new ArrayList<>();
		for(User u : userSet) {
			list.add(UserUtility.copyToUserDtoOfAddress(u,address));
		}
		return list;
	}

	@Override
	public UserDto updateAddress(UpdateAddressDto updateAddressDto) {
		
		User user = userRepository.findByMobile(updateAddressDto.getMobile());
		if(user!=null) {
			Set<Address> addresses = user.getAddress();
			for(Address address : addresses) {
				if(address.getAddress().contains(updateAddressDto.getPrevious_address())
						&& address.getPincode().contains(updateAddressDto.getPrevious_pincode())) {
					addresses.remove(address);
					Address existingAddress = addressRepository.findByAddressAndPincode(updateAddressDto.getPrevious_address(),updateAddressDto.getPrevious_pincode(),user);
					if(existingAddress!=null) {
						existingAddress.setAddress(updateAddressDto.getNew_address());
						existingAddress.setPincode(updateAddressDto.getNew_pincode());
						Address saved = addressRepository.save(existingAddress);
						addresses.add(saved);
					}
					break;
				}
			}
			user.setAddress(addresses);
			User updatedUser = userRepository.save(user);
			UserDto userDto = UserUtility.copyToUserDto(updatedUser);
			return userDto;
		}
		return null;
	}

}
