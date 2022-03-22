package com.desafiolatam.SistemaNoticias2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaNoticias2Application {
	private final static Logger logger = LoggerFactory.getLogger(SistemaNoticias2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SistemaNoticias2Application.class, args);
		logger.debug("debug log");
		logger.info("noticia lista para ser desplegada");
		logger.warn("warning log");
		logger.error("ERROR");
	}

}
