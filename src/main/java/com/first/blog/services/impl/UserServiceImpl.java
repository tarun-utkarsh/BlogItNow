package com.first.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.first.blog.config.AppConstants;
import com.first.blog.entities.Role;
import com.first.blog.entities.User;
import com.first.blog.exceptions.ResourceNotFoundException;
import com.first.blog.payloads.UserDto;
import com.first.blog.repositories.RoleRepo;
import com.first.blog.repositories.UserRepo;
import com.first.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.userDtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToUserDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user =this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
	
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);

	}
	
	private User userDtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);
		
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
		
	}
	
	public UserDto userToUserDto(User user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		return userDto;
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		//encoded password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		//roles
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		user.getRoles().add(role);
		
		User newUser = this.userRepo.save(user);
		
		return this.modelMapper.map(newUser, UserDto.class);
		
	}

}
