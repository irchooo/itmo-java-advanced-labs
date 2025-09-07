package ru.itmo.JavaAdvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itmo.JavaAdvanced.dto.ExampleDto;

@SpringBootApplication
public class JavaAdvancedApplication {
    public static final ExampleDto EXAMPLE_DTO = new ExampleDto();

	public static void main(String[] args) {
		EXAMPLE_DTO.setId(1L);
        System.out.println(EXAMPLE_DTO.getId());

        SpringApplication.run(JavaAdvancedApplication.class, args);
	}

}
