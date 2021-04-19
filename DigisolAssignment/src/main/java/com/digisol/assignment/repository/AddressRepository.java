package com.digisol.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digisol.assignment.entity.Address;
import com.digisol.assignment.entity.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query(value="SELECT a FROM Address a WHERE " + "LOWER(a.address) LIKE LOWER(CONCAT('%',:address, '%'))")
	List<Address> findByAddress(@Param("address") String address);
	
	@Query(value="SELECT a FROM Address a WHERE " + "LOWER(a.address) LIKE LOWER(CONCAT('%',:previous_address, '%')) AND a.pincode = :previous_pincode AND a.user=:userId")
	Address findByAddressAndPincode(String previous_address, String previous_pincode,User userId);

}
