package co.com.czuluaga.udemy.microservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

}
