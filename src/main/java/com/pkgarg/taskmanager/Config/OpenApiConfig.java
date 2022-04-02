package com.pkgarg.taskmanager.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Basic;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Task Manager API")
                        .description("Swagger UI for task manager app")
                        .version("v0.0.1")
                        .contact(new Contact().name("Pramod Garg").email("pramod.garg.pkg@gmail.com")));
    }
}
