package com.vti.blogapp;

import com.vti.blogapp.entity.Role;
import com.vti.blogapp.entity.User;
import com.vti.blogapp.repository.RoleRepository;
import com.vti.blogapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class BlogappApplication implements CommandLineRunner {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	public static void main(String[] args) {

		SpringApplication.run(BlogappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = new User();
		user.setName("Nguyen Thi Thai Hang");
		user.setUsername("Thai Hang");
		user.setEmail("thaihang@gmail.com");
		user.setPassword(passwordEncoder.encode("123456789hang"));
		var adminRole = roleRepository.findByType(Role.Type.ADMIN);
		var userRole = roleRepository.findByType(Role.Type.USER);
		user.setRoles(Set.of(adminRole, userRole));
		userRepository.save(user);
	}
}
