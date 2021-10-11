package br.com.supera.game.store;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "br.com.supera.game.store.service",
				 "br.com.supera.game.store.repository",
				 "br.com.supera.game.store.controler" })
public class GameStoreApp {

	public static void main(String[] args) {
		SpringApplication.run(GameStoreApp.class, args);
	}
	
	@Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.mariadb.jdbc.Driver")
                .url("jdbc:mariadb://127.0.0.1:3306/mydb")
                .username("root")
                .password("root")
                .build();
    }
}
