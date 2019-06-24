package com.atguigu.ssm.util;

import javax.servlet.http.HttpServletRequest;

import com.atguigu.ssm.beans.Employee;
import com.github.pagehelper.PageInfo;

/**
 * 组件化分页思想: 
 * 
 */

public class PageUtils {
	
	/**
	 * 将来该方法会返回在Jsp页面中显示分页用到的所有的信息.
	 * 
	 * 首页   上一页    1 2 3 4 5    下一页   尾页 
	 * 
	 */
	public  static String  getPageString(PageInfo<Employee>  info,
			HttpServletRequest req) {
		StringBuffer buffer = new StringBuffer();
		
		String str = req.getContextPath();
		
		//首页
		buffer.append("<a href='"+str+"/emps/1'>首页</a>");
		buffer.append("&nbsp;&nbsp;");
		
		//上一页
		if(info.isIsFirstPage()) {
			buffer.append("上一页");
		}else {
			buffer.append("<a href='"+str+"/emps/"+(info.getPageNum()-1)+"'>上一页</a>");
		}
		
		buffer.append("&nbsp;&nbsp;");
		// 1 2 3 4  5 
		int [] nums = info.getNavigatepageNums();
		for (int i : nums) {
			//当前也高亮
			if(i == info.getPageNum()) {
				buffer.append("<a href='"+str+"/emps/"+i+"'><font color='green'>"+i+"</font></a>");
				buffer.append("&nbsp;&nbsp;");
			}else {
				buffer.append("<a href='"+str+"/emps/"+i+"'>"+i+"</a>");
				buffer.append("&nbsp;&nbsp;");
			}
			
		}
		
		//下一页
		if(info.isIsLastPage()) {
			buffer.append("下一页");
		}else {
			buffer.append("<a href='"+str+"/emps/"+(info.getPageNum()+1)+"'>下一页</a>");
		}
		
		buffer.append("&nbsp;&nbsp;");
		
		//尾页
		buffer.append("<a href='"+str+"/emps/"+info.getPages()+"'>尾页</a>");
		
		
		return buffer.toString();
	}
}
