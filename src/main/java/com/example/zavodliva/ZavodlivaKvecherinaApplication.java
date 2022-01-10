package com.example.zavodliva;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.zavodliva.repository.ArtistRepository;
import com.example.zavodliva.user.entity.Role;
import com.example.zavodliva.user.entity.RoleName;
import com.example.zavodliva.user.entity.RoleRepository;
import com.example.zavodliva.user.entity.UserRepository;

@SpringBootApplication
public class ZavodlivaKvecherinaApplication {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ZavodlivaKvecherinaApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		try {
			
			roleRepository.save(new Role(1L, RoleName.ROLE_ADMIN));
			roleRepository.save(new Role(2L, RoleName.ROLE_USER));
			
			
		} catch (Exception e) {
			System.out.println("Post construct NOT called");
	}
	
	}
}
