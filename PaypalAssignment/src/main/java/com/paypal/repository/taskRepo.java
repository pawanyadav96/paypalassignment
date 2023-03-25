package com.paypal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.task;

public interface taskRepo extends JpaRepository<task, Integer>{

}
