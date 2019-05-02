package ru.grig.labyrinth_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

@SpringBootApplication
public class LabyrinthAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabyrinthAppApplication.class, args);
	}

}
