package com.tf8.quizapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("API TF8 &#x27;Jeux&#x27; Quiz")
                .description("Définition de l'API RESTful pour la plateforme de quiz interactif 'Jeux' de TF8. Cette API gère l'authentification des utilisateurs, l'administration des quiz et le déroulement du jeu en temps réel.  La synchronisation en temps réel (comme l'affichage des questions et des résultats) est gérée via WebSockets. ")
                .termsOfService("")
                .version("1.0.0")
                .license(new License()
                    .name("")
                    .url("http://unlicense.org"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("")));
    }

}
