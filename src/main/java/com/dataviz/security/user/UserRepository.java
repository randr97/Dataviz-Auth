package com.dataviz.security.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  @Query("select u from User u where u.email = (?1)")
	User findByUserEmailAndUserPassword(String userEmail);

}
