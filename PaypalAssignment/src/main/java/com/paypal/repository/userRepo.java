package com.paypal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.user;

public interface userRepo extends JpaRepository<user, Integer>{

}
