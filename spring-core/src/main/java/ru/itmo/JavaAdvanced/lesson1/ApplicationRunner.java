package ru.itmo.JavaAdvanced.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itmo.JavaAdvanced.lesson1.dto.ExampleDto;

@SpringBootApplication
public class ApplicationRunner {

	public static void main(String[] args) {
		ExampleDto exampleDto = new ExampleDto();
        exampleDto.setId(1L);
        System.out.println(exampleDto.getId());

        SpringApplication.run(ApplicationRunner.class, args);
	}

}
