package br.com.dmsexpurgo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties("db-config")
@Validated
public class DbConfig {

	private String sqlSave;
	private String sqlSelectOne;
	private String sqlDelete;
	private String url;
	private String username;
	private String password;
	private String driverClassName;
	


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getSqlDelete() {
		return sqlDelete;
	}

	public void setSqlDelete(String sqlDelete) {
		this.sqlDelete = sqlDelete;
	}

	public String getSqlSelectOne() {
		return sqlSelectOne;
	}

	public void setSqlSelectOne(String sqlSelectOne) {
		this.sqlSelectOne = sqlSelectOne;
	}

	public String getSqlSave() {
		return sqlSave;
	}

	public void setSqlSave(String sqlSave) {
		this.sqlSave = sqlSave;
	}

	
}
