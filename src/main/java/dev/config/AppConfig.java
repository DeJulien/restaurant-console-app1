package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Le st�r�otype @Configuration pr�cise que cette classe servira de configuration.
@Configuration
@ComponentScan({"dev.ihm","dev.service","dev.dao"})
@PropertySource("app.properties")


public class AppConfig {
	
	@Bean
	public Scanner scanner(){
		return  new Scanner (System.in);
	}
}
