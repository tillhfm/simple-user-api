package de.trxsson.userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UserApiApplication is the main class that starts the User API application.
 */
@SpringBootApplication
public class UserApiApplication {

	/**
	 * The main method of the UserApiApplication class.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

}
