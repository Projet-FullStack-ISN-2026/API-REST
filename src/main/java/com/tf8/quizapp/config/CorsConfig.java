package com.tf8.quizapp.config;
 
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class CorsConfig implements WebMvcConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applique la règle sur tous les endpoints de l'API
                .allowedOriginPatterns("*") // Autorise TOUTES les origines (http://localhost:3000, http://192.168.x.x, etc.)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Autorise ces méthodes HTTP
                .allowedHeaders("*") // Autorise tous les headers
                .allowCredentials(true); // Autorise les cookies/auth si besoin
    }
}