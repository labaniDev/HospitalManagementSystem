package com.example.demo.dto;

import com.example.demo.entity.Status;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DoctorDTO {
	
	private Long id;
	private String email;
	private String name;
	private String specialization;
	private String gender;
	private String password;
	private String about;
	private String experience;
	private Boolean isaspecialist;
	private Double fee;
	private String dob;
	private Status status;

}
