package com.lkl.springboot.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
* Title: DataSourceConfig
* Description: 多数据源配置（一）：JdbcTemplate
* 创建一个Spring配置类，定义两个DataSource用来读取application.properties中的不同配置。
* 如下例子中，主数据源配置为spring.datasource.primary开头的配置，
* 第二数据源配置为spring.datasource.secondary开头的配置。
* 
* @author HuangJian
* @date 2017年9月19日
*
*/
@Configuration
public class DataSourceConfig {

	@Bean(name="defaultDataSource")
	@Qualifier("defaultDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource defaultDataSource(){
		
		return DataSourceBuilder.create().build();
	}
	
	
	/**
	* Title: DataSourceConfig.java
	* Description: 
	* spring.datasource.primary前缀
	* bean的name是primaryDataSource
	* @return
	* @author HuangJian
	* @date 2017年9月19日
	*/
	@Bean(name="primaryDataSource")
	@Qualifier("primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.primary")
	public DataSource primaryDataSource(){
		
		return  DataSourceBuilder.create().build();
		
	}
	
	/**
	* Title: DataSourceConfig.java
	* Description: 用@Primary 告诉spring 在犹豫的时候优先选择哪一个具体的实现。
	* spring.datasource.secondary前缀
	* bean的name是
	* @return
	* @author HuangJian
	* @date 2017年9月19日
	*/
	@Bean(name="secondaryDataSource")
	@Qualifier("secondaryDataSource")
	//@Primary
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource secondaryDataSource(){
		
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public JdbcTemplate primaryJdbcTemplate(
			@Qualifier("primaryDataSource") DataSource dataSource){
		
		return new JdbcTemplate(dataSource);
	}
	@Bean
	public JdbcTemplate secondaryJdbcTemplate(
			@Qualifier("secondaryDataSource") DataSource dataSource){
		
		return new JdbcTemplate(dataSource);
	}
	@Bean
	public JdbcTemplate defaultJdbcTemplate(
			@Qualifier("defaultDataSource") DataSource dataSource){
		
		return new JdbcTemplate(dataSource);
	}
	
}
