package com.lkl.springboot.config;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef="entityManagerFactorySecondary",
	transactionManagerRef="transactionManagerSecondary",
	basePackages={"com.lkl.springboot.repository"}
		)
public class JpaSecondaryConfig {

	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource secondaryDataSource;
	
	@Bean(name="entityManagerSecondary")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder){
		
		return entityManagerFactorySecondary(builder).getObject().createEntityManager();
	}
	
	@Bean(name="entityManagerFactorySecondary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(secondaryDataSource)
				.properties(getVendorProperties(secondaryDataSource))
				.packages("com.lkl.springboot.entity")//实体类对应位置
				.persistenceUnit("secondaryPersistenceUnit")
				.build();
	}

	@Autowired
	private JpaProperties jpaProperties;
	
	private Map<String, String> getVendorProperties(DataSource secondaryDataSource) {
		
		return jpaProperties.getHibernateProperties(secondaryDataSource);
	}
	
	@Bean(name="transactionManagerSecondary")
	public PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder){
		
		return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
	}
	
}
