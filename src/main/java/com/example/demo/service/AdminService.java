package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminNotDeletedException;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.exception.AdminNotUpdatedException;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	PasswordEncoder encoder;
	
	public void addAdmin(AdminDTO adminDTO) {
		Admin admin=modelMapper.map(adminDTO, Admin.class);
		admin.setPassword(encoder.encode(adminDTO.getPassword()));
		adminRepo.save(admin);
	}
	
	public Admin getAdminById(Long id)throws AdminNotFoundException{
		Optional<Admin> admin=adminRepo.findById(id);
		if(admin.isPresent()) {
			return admin.get();
		}
		throw new AdminNotFoundException("admin not found");
	}
	
	public boolean updateAdmin(AdminDTO adminDTO)throws AdminNotUpdatedException  {
		Optional<Admin> adminOptional=adminRepo.findById(adminDTO.getId());
		if(adminOptional.isPresent()) {
			Admin admin=adminOptional.get();
			admin.setName(adminDTO.getName());
			admin.setPassword(adminDTO.getPassword());
			admin.setPassword(encoder.encode(adminDTO.getPassword()));
			adminRepo.save(admin);
			return true;
		}
		throw new AdminNotUpdatedException("error updating admin");
	}
	public boolean deleteAdmin(Long id) throws AdminNotDeletedException {
		Optional<Admin> adminOptional=adminRepo.findById(id);
		if(adminOptional.isPresent()) {
			Admin admin=adminOptional.get();
			adminRepo.delete(admin);
			return true;
		}
		throw new AdminNotDeletedException("error deleting admin");
	}

}
