package com.digisol.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digisol.assignment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByMobile(String mobile);

}
