package com.example.druid_flyway_mybatis_mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author river
 */
@MapperScan("com.example.druid_flyway_mybatis_mysql.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DruidFlywayMybatisMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DruidFlywayMybatisMysqlApplication.class, args);
	}

}
