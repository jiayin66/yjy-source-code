package com.yjy;

import com.yjy.annotation.User;
import com.yjy.aop.SqlSession;
import com.yjy.mapper.UserMapper;

public class Test {
	public static void main(String[] args) {
		UserMapper userMapper = SqlSession.getSession(UserMapper.class);
		userMapper.getName("1");
	}
}
