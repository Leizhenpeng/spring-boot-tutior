package com.example.druid_flyway_mybatis_mysql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author river
 */
@Data
@NoArgsConstructor
public class User {
	private Long id;
	private String name;
	private Integer age;

	public User(Long id, String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}
