package com.rocket.gestaovagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(info = @Info(
	title = "Gestão de Vagas",
	version = "1",
	description = "API para gestão de vagas de emprego"
))
@SpringBootApplication
public class GestaovagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaovagasApplication.class, args);
	}

}
