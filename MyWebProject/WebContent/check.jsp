<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.jdbc.learn.dao.LoginDao"%>
<%@ page import="org.jdbc.dao.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		Login loginInfo = new Login(name,pwd);
		
		LoginDao Dao = new LoginDao();
		
		int result = Dao.login(loginInfo);
		if(result > 0 ){
			out.print("登录成功！");
		}else if(result==0){
			out.print("登录失败");
		}else{
			out.print("系统异常");
		}
	%>
</body>
</html>