package com.sijiback;

import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SijiBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SijiBackApplication.class, args);

	}

}
