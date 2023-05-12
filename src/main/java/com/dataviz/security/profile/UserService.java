package com.dataviz.security.profile;
import com.dataviz.security.user.*;

import com.dataviz.security.auth.RegisterRequest;
public interface UserService {
	
	// User registerUser(User user) throws UserAlreadyExistsException;

	UserResponse updateUser(RegisterRequest userDetails);
	RegisterRequest getUser(String token);
	UserResponse deleteUser(String userEmail);

	// User changePassword(String userPassword, String userEmail) throws Exception;

	// User getUserByEmailandPassword(String userEmail, String userPassword) throws UserNotFoundException;
 
}