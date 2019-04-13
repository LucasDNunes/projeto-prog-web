package br.unisul.progweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
public class DevConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean inicializaBancoDeDados(DbService dbService) throws ParseException {
        if (!"create".equals(strategy)) {
            return false;
        }
        dbService.inicializaBancoDeDados();
        return true;
    }
}
