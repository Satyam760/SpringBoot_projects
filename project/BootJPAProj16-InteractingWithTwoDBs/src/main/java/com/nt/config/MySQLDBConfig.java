package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repository.offers",
                       entityManagerFactoryRef = "mysqlEMF",
                       transactionManagerRef = "mysqlTxMgmr")

public class MySQLDBConfig {
	
	//Data source obj
	@Bean("MySQLDs")
	@ConfigurationProperties(prefix = "mysql.ds")
	//@Primary
	public DataSource createOraDs() {
		return DataSourceBuilder.create().build();
	}
	
	//create LocalContainerEntityManagerFactoryBean that gives EntityManagerFactory obj
	@Bean("mysqlEMF")
	//@Primary
	public LocalContainerEntityManagerFactoryBean createLCEMFBForMySQL(EntityManagerFactoryBuilder emBuilder) {
		//prepare Hibernet propertied
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		map.put("hibernate.hbm2ddl.auto","update");
		map.put("hibernate.show_sql","true");
		map.put("hibernate.fomat_sql", "true");
		//create LocalContainerEntityManagerFactoryBean  class obj using EntityManagerFactoryBilder obj
		return emBuilder.dataSource(createOraDs()).packages("com.nt.entity.offers").properties(map).build();
	}
	
	@Bean("mysqlTxMgmr")
	//@Primary
	public JpaTransactionManager crateTxMgmrForMySQL(@Qualifier("mysqlEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
	

}
