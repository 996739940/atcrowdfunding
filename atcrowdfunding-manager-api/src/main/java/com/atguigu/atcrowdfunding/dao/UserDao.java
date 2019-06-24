package com.atguigu.atcrowdfunding.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.User;

public interface UserDao {

	int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    /**
     * 用户名唯一
     * @param paramMap
     * @return
     */
	User getUserByLogin(Map<String, Object> paramMap);

	List<User> queryUserList(Map<String, Object> paramMap);

	Integer countUser(Map<String, Object> paramMap);
}
