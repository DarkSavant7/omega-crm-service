package ru.darksavant.omegacrmservice.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger config to auto doc REST apis
 * http://localhost:8189/omega/swagger-ui.html
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key", getSecuritySchemesItem()))
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"));
    }

    private SecurityScheme getSecuritySchemesItem() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
    }

}
