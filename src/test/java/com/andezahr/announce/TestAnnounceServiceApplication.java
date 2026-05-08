package com.andezahr.announce;

import org.springframework.boot.SpringApplication;

public class TestAnnounceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(AnnounceServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
