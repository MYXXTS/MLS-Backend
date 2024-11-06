package com.myxxts.mls.app.configs;

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
        .info(new Info().title("MLS API")
            .description("MLS API")
            .version("v1.0.0")
            .license(
                new License()
                    .name("AGPL v3")
                    .url("https://www.gnu.org/licenses/agpl-3.0.html")))
        .externalDocs(
            new ExternalDocumentation()
                .description("MLS API Documentation")
                .url("https://mls.myxxts.com/docs"));
  }
}
