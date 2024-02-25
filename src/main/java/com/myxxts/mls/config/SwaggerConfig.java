package com.myxxts.mls.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SwaggerConfig {
    @Bean
    public OpenAPI mlsOpenApi() {
        return new OpenAPI()
                .info(new Info().title("My Log Space")
                        .description("My Log Space Backend Api Document")
                        .version("V1")
                        .license(
                                new License().name("Apache").url("http://www.apache.org/licenses/LICENSE-2.0.html")
                        ))
                .externalDocs(new ExternalDocumentation()
                        .description("My Log Space")
                        .url("https://www.myxxts.com")
                );
    }
}
