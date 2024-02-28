package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Admin;

public interface AdminRepo extends CrudRepository<Admin,Long>,JpaRepository<Admin,Long>{
	
	Admin  findByUsername(String username);

}
