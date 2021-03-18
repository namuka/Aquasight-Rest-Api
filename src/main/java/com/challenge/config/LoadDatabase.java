package com.challenge.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challenge.domain.Data;
import com.challenge.domain.ERole;
import com.challenge.domain.Role;
import com.challenge.repository.DataRepository;
import com.challenge.repository.RoleRepository;
import com.challenge.repository.UserRepository;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

		@Bean		
		CommandLineRunner initDatabase(DataRepository repository, RoleRepository roleRepository, UserRepository userRepository) {
	
		Role newAdminRole = roleRepository.save(new Role(ERole.ADMIN));
	    return args -> {
	    	//log.info("Preloading " + userRepository.save(new User("admin@example.com", "password", roleRepository.save(newAdminRole))));
	    	log.info("Preloading " + repository.save(new Data(10.5, 25.5)));
	    	log.info("Preloading " + repository.save(new Data(11.5, 35.5)));
	    	log.info("Preloading " + repository.save(new Data(25.5, 45.5)));
	    	log.info("Preloading " + repository.save(new Data(9.5, 99.5)));
	    	log.info("Preloading " + repository.save(new Data(55.5, 75.5)));
	    	log.info("Preloading " + repository.save(new Data(88.5, 100.5)));
	    	log.info("Preloading " + repository.save(new Data(4.5, 44.5)));
	    	log.info("Preloading " + repository.save(new Data(3.5, 33.5)));
	    	
	    };
	  }
}
