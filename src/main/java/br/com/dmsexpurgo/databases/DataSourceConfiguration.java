package br.com.dmsexpurgo.databases;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import br.com.dmsexpurgo.configuration.DbConfig;

@Component
public class DataSourceConfiguration {

	@Autowired
	DbConfig dbConfig;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbConfig.getDriverClassName());
		dataSource.setUrl(dbConfig.getUrl());
		dataSource.setUsername(dbConfig.getUsername());
		dataSource.setPassword(dbConfig.getPassword());

		return dataSource;
	}

}
