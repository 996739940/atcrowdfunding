package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import com.atguigu.atcrowdfunding.util.Page;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/index")
	public String index() {
		return "user/index";
	}

	@RequestMapping("/user/toAdd")
	public String toAdd() {
		return "user/add";
	}

	@ResponseBody
	@RequestMapping("/user/doAdd")
	public Object doAdd(User user) {
		start();
		try {
			int i = userService.saveUser(user);
			
			success(i==1);
		} catch (Exception e) {
			success(false);
			e.printStackTrace();
		}
		return end();
	}

	@ResponseBody
	@RequestMapping("/user/queryPage")
	public Object queryPage(Integer pageno, Integer pagesize) {
		start();

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("pageno", pageno);
			paramMap.put("pagesize", pagesize);

			Page<User> page = userService.queryPage(paramMap);

			data(page);
			success(true);
		} catch (Exception e) {
			success(false);
		}

		return end();
	}

}
