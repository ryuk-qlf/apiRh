package fr.facil.facilapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class
FacilapiApplication {


    public static void main(String[] args) {
        SpringApplication.run(FacilapiApplication.class, args);
    }
}
