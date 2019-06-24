package com.atguigu.atcrowdfunding.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.atguigu.atcrowdfunding.util.Const;

public class StartSystemListener implements ServletContextListener {

	//服务器启动时执行
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//在服务器启动时， 将项目上下文存放到application域中，给jsp页面使用:	${APP_PATH}	${pagecontext.request.contextPath}
		ServletContext application = sce.getServletContext();
		String contextPath = application.getContextPath();
		application.setAttribute(Const.APP_PATH,contextPath);
		System.out.println("==============================			监听器启动			==============================");
		System.out.println("将上下文路径存放到application域中=	" + contextPath);
	}

	//服务器停止时或者项目卸载时执行
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
