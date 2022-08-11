package com.andryanstgkr.desmartweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class LocaleConfig {
   @Bean
   public AcceptHeaderLocaleResolver localeResolver() {
      final AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
      // resolver.setDefaultLocale(Locale.US);
      return resolver;
   }

   @Bean("messageSource")
   public ReloadableResourceBundleMessageSource messageSource() {
      ReloadableResourceBundleMessageSource messageSource =
            new ReloadableResourceBundleMessageSource();
      // Locale.setDefault(Locale.US);
      messageSource.setBasename("classpath:messages/message");
      messageSource.setCacheSeconds(3600); // Refresh cache once per hour.
      return messageSource;
   }

   
}
