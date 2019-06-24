package com.atguigu.ssm.mapper;

import java.util.List;

import com.atguigu.ssm.beans.Employee;

public interface EmployeeMapper {

	public List<Employee> selectEmployees();
}
