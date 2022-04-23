package com.security.auth.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class JWTRequest {
	
	private String userName;
	private String password;

}
