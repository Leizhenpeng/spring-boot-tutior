package com.example.druid_flyway_mybatis_mysql.mapper;

import com.example.druid_flyway_mybatis_mysql.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author river
 */
@Mapper
public interface UserMapper {
	/**
	 * 根据姓名寻找用户
	 * @param name 用户名
	 * @return User	用户
	 */
	@Select("SELECT * FROM user WHERE NAME = #{name} LIMIT 1")
	User findByName(@Param("name") String name);


	/**
	 * 插入用户
	 *
	 * @param name 用户名
	 * @param age  年龄
	 */
	@Insert("INSERT INTO user(NAME, AGE) VALUES(#{name}, #{age})")
	void insert(@Param("name") String name, @Param("age") Integer age);

}
