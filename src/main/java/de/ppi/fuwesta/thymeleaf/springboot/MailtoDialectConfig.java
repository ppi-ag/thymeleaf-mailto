package de.ppi.fuwesta.thymeleaf.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.ppi.fuwesta.thymeleaf.mail.MailToDialect;

@Configuration
public class MailtoDialectConfig {

    @Bean
    public MailToDialect mailtoDialect() {
        return new MailToDialect();
    }

}
