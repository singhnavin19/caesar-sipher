package com.cipher.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cipher")
public class CaesarSipherApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaesarSipherApplication.class, args);
	}

}
