package cl.desafiolatam.contactmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactmanagerApplication {

	private final static Logger logger = LoggerFactory.getLogger(ContactmanagerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ContactmanagerApplication.class, args);
		logger.debug("debug log");
		logger.info("info log");
		logger.warn("warning log");
		logger.error("error log"); 

	}

}
