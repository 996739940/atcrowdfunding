package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;

@Controller
public class DispatcherController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session != null) {
			// 清空session
			session.removeAttribute(Const.LOGIN_USER);
			// 销毁session
			session.invalidate();
		}
		return "redirect:/login.htm";
	}

	// 表示启用HttpMessageConverter消息转换器
	// 一：控制其返回方法为Object对象(User,List,Map):
	// MappingJackson2HttpMessageConverter：作用是将对象转换为json串
	// 二：控制器方法返回结果为String类型：StringHttpMessageConverter作用：将字符串以流的形式直接返回浏览器
	@ResponseBody
	@RequestMapping("/doLogin")
	public Object doLogin(String loginacct, String userpswd, String type, HttpSession session) {
		start();

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("loginacct", loginacct);
			paramMap.put("userpswd", userpswd);
			paramMap.put("type", type);
			// ctrl + t 进入方法声明的类或接口
			User user = userService.getUserByLogin(paramMap);

			session.setAttribute(Const.LOGIN_USER, user);

			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
			e.printStackTrace();
		}
		return end();
	}

}
