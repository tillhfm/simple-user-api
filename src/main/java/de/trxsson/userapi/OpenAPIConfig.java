package de.trxsson.userapi;

import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * This class is used to modify the api documentation server URLs to use HTTPS. This is for personal use only, and you might want to remove this class before using the application.
 */
@ComponentScan
@Configuration
public class OpenAPIConfig {

    /**
     * The Logger used to log important actions taken in this class.
     */
    private static final Logger logger = Logger.getLogger(OpenAPIConfig.class.getName());

    /**
     * Modifies the API documentation server URLs to use HTTPS.
     *
     * @return An OpenApiCustomizer object that modifies the server URLs.
     */
    @Bean
    public OpenApiCustomizer openApiCustomizer() {
        return openApi -> {
            for (Server server : openApi.getServers()) {
                var oldURL = server.getUrl();
                var newURL = oldURL.replaceFirst("http", "https");
                logger.info("Setting URL \"" + oldURL + "\" to \"" + newURL + "\"");
                server.setUrl(newURL);
            }
        };
    }
}

