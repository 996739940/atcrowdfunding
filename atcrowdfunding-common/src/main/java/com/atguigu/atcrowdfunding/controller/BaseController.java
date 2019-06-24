package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import com.atguigu.atcrowdfunding.util.Page;

/**
 * 局部变量在栈中，每一个线程独一份，没有线程安全问题，
 * 成员变量声明在队中，只有一份，虽然引用可以有多个，但是会有线程安全问题
 * 解决成员变量的线程安全问题，使用ThreadLocal，会将数据绑定到当前线程上，
 * 独立的初始化一个当前变量的副本
 * @author alienware
 *
 */
public class BaseController {

	//ThreadLocal是一个工具，可以将任意数据绑定到当前线程上
	//注意：只有绑定的数据是多例才能解决线程安全问题
	ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String,Object>>();
	
	public void start() {
		Map<String, Object> result = new HashMap<String, Object>();
		threadLocal.set(result);	//将数据绑定到当前线程上
	}
	
	public void success(boolean success) {
		threadLocal.get().put("success",success);	//从当前线程上获取绑定数据
	}
	
	public void message(String message) {
		threadLocal.get().put("message", message);
	}
	
	public void data(Object data) {
		threadLocal.get().put("data", data);
	}
	
	public Map<String, Object> end() {
		return threadLocal.get();
	}
}
