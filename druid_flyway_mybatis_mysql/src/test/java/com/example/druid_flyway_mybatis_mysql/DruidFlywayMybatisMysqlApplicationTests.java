package com.example.druid_flyway_mybatis_mysql;

import com.example.druid_flyway_mybatis_mysql.entity.User;
import com.example.druid_flyway_mybatis_mysql.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
@Slf4j
@Transactional
@SpringBootTest
class DruidFlywayMybatisMysqlApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void test() {
		userMapper.insert("river", 23);
		User user = userMapper.findByName("river");
		log.warn(user.toString());
		Assert.assertEquals(23, user.getAge().intValue());
	}

}
