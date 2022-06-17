
package com.nepalaya.up.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfigurers {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5500/", "https://mnzit.github.io","http://localhost:4200","https://universityportal-fe.pages.dev")
                        .allowCredentials(true)
                        .allowedHeaders("Authorization", "Cache-Control", "Content-Type")
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .exposedHeaders("Authorization");
            }
        };
    }


}
