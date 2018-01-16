package com.mj.anagram.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication(scanBasePackages={"com.mj.anagram.controller", "com.mj.anagram.service"})
public class MjAnagramApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjAnagramApplication.class, args);
	}
}
