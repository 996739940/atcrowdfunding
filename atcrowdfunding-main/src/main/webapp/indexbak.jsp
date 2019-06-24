<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 	前台路径是部署在tomcat服务器上，最终执行在浏览器端
		/开头表示的是/root	即：localhost:8080
		但是并没有进到当前上下文的路径，所以可以从服务器端获取上下问路径，并封装
		然后在这里使用，前台路径：${APP_PATH}  
		<script type="text/javascript" src="${APP_PATH}/jquery/.."></script>	-->
</head>
<body>
<!-- 后台路径：/开头表示从应用上下文路径来查找资源，即：localhost:8080//atcrowdfunding-main/
		jsp标签表示是从服务器端执行，/则解释为当前上下文，即webapp目录下
		<jsp:include page="/index.htm"></jsp:forward>
	 -->
<jsp:forward page="/index.htm"></jsp:forward>
</body>
</html>