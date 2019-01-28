package com.gslab.talent.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.gslab.talent.services.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class GsTalentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsTalentServicesApplication.class, args);
	}

}

