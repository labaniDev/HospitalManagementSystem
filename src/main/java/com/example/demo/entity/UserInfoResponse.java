package com.example.demo.entity;

import lombok.Data;

@Data
public class UserInfoResponse {
	Long id;
	String email;
	String jwtToken;
	
	public UserInfoResponse(Long id,String email,String jwtToken) {
		this.id=id;
		this.email=email;
		this.jwtToken=jwtToken;
	}
	

}
