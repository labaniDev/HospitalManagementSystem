package com.example.demo.service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
	 public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	 
	 public Boolean existsByEmail(String email) {
		 return userRepo.existsByEmail(email);
	 }
	 
	 public void createUser(UserDTO userDTO) {
		 try {
			 LOGGER.debug("Inside CreateUser:"+userDTO.toString());
			 User user=modelMapper.map(userDTO, User.class);
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			  LocalDateTime now = LocalDateTime.now(); 
			  userDTO.setDob(dtf.format(now));
			  user.setPassword(encoder.encode(userDTO.getPassword()));
			  userRepo.save(user);
		 }catch(Exception ex){
			 LOGGER.error("Exception in createUser:"+ex.getMessage());
		 }
	 }

}
