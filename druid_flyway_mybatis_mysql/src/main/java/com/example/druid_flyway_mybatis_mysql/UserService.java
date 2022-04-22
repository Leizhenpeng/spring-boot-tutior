package com.example.druid_flyway_mybatis_mysql;

import com.example.druid_flyway_mybatis_mysql.entity.User;

import java.util.List;

/**
 * @author river
 */
public interface UserService {

	/**
	 * 新增一个用户
	 * @param name 用户名
	 * @param age	年龄
	 * @return	新增的用户
	 */
	int create(String name, int age);

	/**
	 * 根据name 查询用户
	 * @param name	用户名
	 * @return	用户
	 */
	List<User> getByName(String name);


	/**
	 * 根据 name 删除用户
	 * @param name	用户名
	 * @return	删除的用户数量
	 */
	int deleteByName(String name);

	/**
	 * 查询用户数量
	 * @return	用户数量
	 */
	int getUserCount();

	/**
	 * 删除所有用户
	 * @return	删除的用户数量
	 */
	int deleteAll();
}
