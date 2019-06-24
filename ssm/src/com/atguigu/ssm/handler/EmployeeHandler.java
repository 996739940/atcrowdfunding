package com.atguigu.ssm.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.ssm.beans.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.atguigu.ssm.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 显示所有的员工信息
	 */
	@RequestMapping(value="/emps/{pageNum}",method=RequestMethod.GET)
	public String listAllEmps(Map<String,Object> map,
			@PathVariable("pageNum")Integer pageNum,
			HttpServletRequest req) {
		
		//设置分页信息
		PageHelper.startPage(pageNum,1);
		
		List<Employee> emps = employeeService.selectAllEmps();
		
		//获取PageInfo对象
		PageInfo<Employee> info = new PageInfo<>(emps,5);
		
		//获取分页数据
		String pageString = PageUtils.getPageString(info,req);
		
		map.put("pageString", pageString);
		
		map.put("emps", emps);
		
		return "list";
	}
}
