package com.example.springboot_be;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(
        name="Keycloak",
        openIdConnectUrl = "http://localhost:8080/realms/quyennv/.well-known/openid-configuration",
        scheme = "bearer",
        type = SecuritySchemeType.OPENIDCONNECT,
        in = SecuritySchemeIn.HEADER
)

public class SpringbootBeApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootBeApplication.class, args);
    }

}
