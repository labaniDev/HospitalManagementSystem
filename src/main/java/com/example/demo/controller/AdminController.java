package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<AdminDTO> addAdmin(@RequestBody AdminDTO adminDTO){
		adminService.addAdmin(adminDTO);
		return new ResponseEntity<AdminDTO>(HttpStatus.CREATED);
		
	}
	@GetMapping("/getAdminById/{id}")
	public ResponseEntity<AdminDTO> getAdminById(@PathVariable("id") Long id) throws AdminNotFoundException  {
		 Admin admin=adminService.getAdminById(id) ;
		return  new ResponseEntity<AdminDTO>(HttpStatus.OK) ;
		
	}

}
