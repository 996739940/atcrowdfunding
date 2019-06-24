package com.atguigu.atcrowdfunding.service;

import java.util.Map;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.util.Page;

public interface UserService {

	User getUserByLogin(Map<String, Object> paramMap);

	Page<User> queryPage(Map<String, Object> paramMap);

	int saveUser(User user);

}
