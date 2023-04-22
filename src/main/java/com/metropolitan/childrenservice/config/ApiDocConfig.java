package com.metropolitan.childrenservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@OpenAPIDefinition
@Configuration
public class ApiDocConfig {
    @Bean
    public OpenAPI baseOpenAPI() throws IOException {

        Components components = new Components();

        return new OpenAPI()
                .components(components)
                .info(new Info().title("Metro Children").version("1.0.0").description("Child API"));
    }



//    @Bean
//    public GroupedOpenApi childApi() {
//        String[] paths = {"/api/v1/**"};
//        return GroupedOpenApi.builder()
//                .group("child")
//                .pathsToMatch(paths)
//                .build();
//    }
}
