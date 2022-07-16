package com.design.patterns.project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de inventario de vacunas COVID")
                        .version("1.0")
                        .description("Sistema de gestión para inventario de vacunas COVID para una empreza XYZ. <br />"
                                +"El mismo presenta una documentación de un conjunto de servicios para el consumo de esta API  <br /> <br />"
                                +"<strong>Desarrollado por:</strong> <br /> <br />"
                                +"Bryam Vega <br />"
                                +"Pablo Calderon <br />"
                                +"Andres Buestan <br />"
                                +"Cristian Moreno <br />")
                        .contact(new Contact().email("vegabryam40@gmail.com"))
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
