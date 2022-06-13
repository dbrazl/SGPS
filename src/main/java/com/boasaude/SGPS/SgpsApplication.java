package com.boasaude.SGPS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class SgpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgpsApplication.class, args);
	}
	
    @Bean
    public DriverManagerDataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://sgps.cp5ta9s0g58v.us-east-1.rds.amazonaws.com:5432/sgps_db?createDatabaseIfNotExist=true");
        dataSource.setUsername("postgres");
        dataSource.setPassword("12345678");

        return dataSource;
    }

}
