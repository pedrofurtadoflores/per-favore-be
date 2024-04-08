package com.pfplatform.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Define os endpoints da API que terão CORS configurado
                .allowedOrigins("http://localhost:8080", "https://pf-platform-fe.vercel.app") // Permite solicitações de http://localhost:8080 e https://pf-platform-fe.vercel.app/
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("*") // Cabeçalhos permitidos
                .allowCredentials(true) // Permite credenciais (por exemplo, cookies)
                .maxAge(3600); // Cache de preflight em segundos
    }
}