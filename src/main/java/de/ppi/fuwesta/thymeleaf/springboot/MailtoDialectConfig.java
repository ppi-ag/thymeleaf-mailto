package de.ppi.fuwesta.thymeleaf.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.ppi.fuwesta.thymeleaf.mail.MailToDialect;

/**
 * Auto-Configuration for spring boot.
 * 
 * @author niels
 *
 */
@Configuration
public class MailtoDialectConfig {

    /**
     * Create the {@link MailToDialect}-Bean.
     * 
     * @return the {@link MailToDialect}-Bean.
     */
    @Bean
    public MailToDialect mailtoDialect() {
        return new MailToDialect();
    }

}
