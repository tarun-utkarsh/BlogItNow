package com.first.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.first.blog.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter
//@JsonIgnoreProperties(value={"password"})
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min = 4, message = "Username must be minimum of 4 characters")
	private String name;

	@Email(message = "Email address is not valid")
	private String email;

	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be minimum of 3 characters and maximum of 10 characters")
	private String password;

	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

}
