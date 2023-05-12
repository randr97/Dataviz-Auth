package com.dataviz.security.profile;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.dataviz.security.auth.*;
import com.dataviz.security.config.JwtService;
import com.dataviz.security.user.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

	private final UserService service;
	private final JwtService jwtService;
	

	@PostMapping("/profile-update")
	public ResponseEntity<UserResponse> updateUser(@RequestBody RegisterRequest updatedUser) {
		return ResponseEntity.ok(service.updateUser(updatedUser));
	}

	@GetMapping("/profile")
	public ResponseEntity<RegisterRequest> getUser(@RequestHeader("Authorization") String token) {
		return ResponseEntity.ok(service.getUser(jwtService.extractUsername(token.replaceFirst("Bearer ", ""))));
	}

	@GetMapping("/delete")
	public ResponseEntity<UserResponse> deleteUser(@RequestHeader("Authorization") String token) {
		return ResponseEntity.ok(service.deleteUser(jwtService.extractUsername(token.replaceFirst("Bearer ", ""))));
	}

}