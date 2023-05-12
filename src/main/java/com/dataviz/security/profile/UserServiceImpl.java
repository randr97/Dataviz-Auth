package com.dataviz.security.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dataviz.security.user.*;

import lombok.RequiredArgsConstructor;

import com.dataviz.security.auth.RegisterRequest;
import com.dataviz.security.config.JwtService;
import com.dataviz.security.token.TokenRepository;
import java.util.*;
import com.dataviz.security.token.*;

import static com.dataviz.security.user.Role.ADMIN;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
    
	/* update a new user (changes to be done for other fields)*/  
	public UserResponse updateUser(RegisterRequest userDetails) {
		User user = userRepository.findByUserEmailAndUserPassword(userDetails.getEmail());
		// User rr = User.builder()
		// 			.firstname(userDetails.getFirstname())
		// 			.lastname(userDetails.getLastname())
		// 			.email(user.getEmail())
		// 			.role(ADMIN).build();
		// userRepository.save(rr);
		user.setEmail(user.getEmail());
		user.setFirstname(userDetails.getFirstname());
		user.setLastname(userDetails.getLastname());
		if(!userDetails.getPassword().isEmpty() || userDetails.getPassword() != null) {
			System.out.println(passwordEncoder.encode(userDetails.getPassword()));
			user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		}
		userRepository.save(user);
		return new UserResponse("Successfully Updated");
	}

	@Override
	public RegisterRequest getUser(String userEmail) {
		User user = userRepository.findByUserEmailAndUserPassword(userEmail);
		return RegisterRequest.builder()
					.firstname(user.getFirstname())
					.lastname(user.getLastname())
					.email(user.getEmail())
					.role(ADMIN)
					.build();
	}

	@Override
	public UserResponse deleteUser(String userEmail) {
		User user = userRepository.findByUserEmailAndUserPassword(userEmail);
		userRepository.delete(user);
		return new UserResponse("Successfully Deleted");
	}
}
