package com.atguigu.atcrowdfunding.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.dao.UserDao;
import com.atguigu.atcrowdfunding.exception.LoginException;
import com.atguigu.atcrowdfunding.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;
import com.atguigu.atcrowdfunding.util.Page;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByLogin(Map<String, Object> paramMap) {
		// 1.密码加密
		String userpswd = (String) paramMap.get("userpswd");
		String newUserpswd = MD5Util.digest(userpswd);

		// 2.调用DAO查询用户对象
		User user = userDao.getUserByLogin(paramMap);

		// 3.判断user对象是否为null
		if (user == null) {
			throw new LoginException(Const.LOGIN_LOGINACCT_ERROR);
		}

		// 4.判断密码是否一致
		if (!user.getUserpswd().equals(newUserpswd)) {
			throw new LoginException(Const.LOGIN_USERPSWD_ERROR);
		}

		// 5.将user返回
		return user;
	}

	/**
	 * 分页的实现
	 */
	@Override
	public Page<User> queryPage(Map<String, Object> paramMap) {
		Integer pageno = (Integer) paramMap.get("pageno");
		Integer pagesize = (Integer) paramMap.get("pagesize");
		
		//1.创建page对象
		Page<User> page = new Page<User>(pageno,pagesize);
		int startIndex = page.getStartindex();

		//2.查询这一页数据
		paramMap.put("startIndex", startIndex);
		List<User> userList = userDao.queryUserList(paramMap);
		
		//3.查询总记录数
		Integer totalsize = userDao.countUser(paramMap);
		
		//封装page对象
		page.setDatas(userList);
		page.setTotalsize(totalsize);
		
		//返回page对象
		return page;
	}

	@Override
	public int saveUser(User user) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		user.setCreatetime(sdf.format(new Date()));
		
		user.setUserpswd(MD5Util.digest(Const.DEFAULT_USERPSWD));
		return userDao.insert(user);
	}

}
