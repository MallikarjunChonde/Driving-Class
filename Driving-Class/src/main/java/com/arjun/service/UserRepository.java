package com.arjun.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arjun.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
