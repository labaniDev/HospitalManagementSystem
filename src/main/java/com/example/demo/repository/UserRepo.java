package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.User;

public interface UserRepo extends CrudRepository<User,Long>,JpaRepository<User,Long> {
	 boolean existsByEmail(String email);
	 User  findByEmail(String email);

}
