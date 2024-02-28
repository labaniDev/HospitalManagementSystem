package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Status;
import com.example.demo.repository.DoctorRepo;

@Service
public class DoctorService {
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	DoctorRepo doctorRepo;
	@Autowired
	PasswordEncoder encoder;
	public static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
	public void addDoctor(DoctorDTO doctorDTO) {
		try {
			LOGGER.debug("Inside add Doctor:"+doctorDTO.toString());
			Doctor doctor=modelMapper.map(doctorDTO, Doctor.class);
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			  LocalDateTime now = LocalDateTime.now(); 
			  doctorDTO.setDob(dtf.format(now));
			doctor.setPassword(encoder.encode(doctorDTO.getPassword()));
			doctor.setStatus(Status.active);
			doctorRepo.save(doctor);
		}catch(Exception ex) {
			LOGGER.error("Exception in add Doctor:"+ex.getMessage());
		}
		
	}

}
