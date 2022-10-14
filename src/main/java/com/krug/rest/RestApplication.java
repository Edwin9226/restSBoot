package com.krug.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.krb5.KrbCryptoException;

@SpringBootApplication
@EnableJpaAuditing
public class RestApplication {
	@Bean
	public PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
