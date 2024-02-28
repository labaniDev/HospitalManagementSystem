package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Doctor;

public interface DoctorRepo extends CrudRepository<Doctor,Long>,JpaRepository<Doctor,Long> {

}
