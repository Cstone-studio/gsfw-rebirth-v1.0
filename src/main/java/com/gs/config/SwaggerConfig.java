package com.gs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Contact contact = new Contact();
        contact.setEmail("liuchengyao85@gmail.com");
        contact.setName("GreenStone");
        contact.setUrl("https://github.com/Cstone-studio/gsfw-rebirth-v1.0");

        Info info = new Info().title("Tutorial Management API").version("1.0").contact(contact).description("This API exposes endpoints to manage tutorials.");

        return new OpenAPI().info(info);
    }
}