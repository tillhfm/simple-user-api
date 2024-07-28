package de.tillhfm.userapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UserApiApplication is the main class that starts the User API application.
 *
 * @since 1.0
 */
@OpenAPIDefinition(servers = {
		@Server(url = "/", description = "User request root URL")
})
@SpringBootApplication
public class UserApiApplication {

	/**
	 * The main method of the UserApiApplication class.
	 *
	 * @param args the command line arguments
	 *
	 * @since 1.0
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

}
