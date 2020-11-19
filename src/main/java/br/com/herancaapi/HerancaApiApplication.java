package br.com.herancaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "br.com.herancaapi.entity")
@ComponentScan(basePackages = "br.com.herancaapi.*")
@EnableJpaRepositories(basePackages = "br.com.herancaapi.repository")
public class HerancaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerancaApiApplication.class, args);
	}

}
