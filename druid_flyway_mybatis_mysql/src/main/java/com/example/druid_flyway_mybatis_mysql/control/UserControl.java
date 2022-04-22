package com.example.druid_flyway_mybatis_mysql.control;

import com.example.druid_flyway_mybatis_mysql.entity.User;
import com.example.druid_flyway_mybatis_mysql.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author river
 */
@RestController
@Slf4j
public class UserControl {
	@Resource
	public UserMapper userMapper;

	@GetMapping("/user/{name}")
	public String findByName(@PathVariable String name) {
		User user = userMapper.findByName(name);
		return user.toString();
	}
}
