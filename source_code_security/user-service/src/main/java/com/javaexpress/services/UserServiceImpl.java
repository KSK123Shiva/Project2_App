package com.javaexpress.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.UserDto;
import com.javaexpress.helper.UserMappingHelper;
import com.javaexpress.model.Credential;
import com.javaexpress.model.User;
import com.javaexpress.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto save(UserDto userDto) {
		log.info("** UserDto : service layer ");
		// secure the password in db using BcryptALgorithm
		String rawPwd = userDto.getCredentailDto().getPassword();
		userDto.getCredentailDto().setPassword(passwordEncoder.encode(rawPwd));
		
		var user = UserMappingHelper.map(userDto);
		var dbUser = userRepository.save(user);
		return UserMappingHelper.map(dbUser);
	}

	@Override
	public UserDto findById(Integer userId) {
		log.info("UserServiceImpl :: findByid {}",userId);
		return userRepository.findById(userId)
				.map(UserMappingHelper::map)
				.orElseThrow(() -> new RuntimeException("UserNot Found Exception"));
	}

	@Override
	public List<UserDto> findAll() {
		log.info("UserServiceImpl :: findAll");
		return userRepository.findAll()
				.stream()
				.map(UserMappingHelper::map)
				.collect(Collectors.toUnmodifiableList());
	}

	@Override
	public UserDto update(Integer userId, UserDto userDto) {
		User existingUser = userRepository.findById(userDto.getUserId())
			.orElseThrow(() ->new RuntimeException("User Not Found"));
		
		BeanUtils.copyProperties(userDto, existingUser,"credential");
		if(userDto.getCredentailDto() != null) {
			Credential credentail = existingUser.getCredential();
			if(credentail == null) {
				credentail = new Credential();
				existingUser.setCredential(credentail);
			}
			BeanUtils.copyProperties(userDto.getCredentailDto(), credentail);
		}
		User updatedUser = userRepository.save(existingUser);
		
		return UserMappingHelper.map(updatedUser);
	}

	@Override
	public void deleteById(Integer userId) {
		log.info("UserServiceImpl :: deleteById");
		userRepository.deleteById(userId);
	}

	public UserDto findByUsername(String username) {
		log.info("UserService :: findByUsername");
		return UserMappingHelper.map(
				userRepository.findByCredentialUsername(username)
				.orElseThrow(() -> new RuntimeException("User Not Found")));
	}
	
	
}
