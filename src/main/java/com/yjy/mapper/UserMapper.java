package com.yjy.mapper;

import com.yjy.annotation.ExParam;
import com.yjy.annotation.ExSelect;

public interface UserMapper {
	@ExSelect("select t.name from user t where t.id=#{id}")
	String getName(@ExParam("id") String id);
}
