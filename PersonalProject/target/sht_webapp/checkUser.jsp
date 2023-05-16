<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="egovframework.user.service.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		System.out.println("여기다...");
	UserVO user = (UserVO) request.getAttribute("user");
		if(user != null){
			session.setAttribute("user", user);
	%>
		<script>
			alert('로그인 성공');
			location.href = '/index.jsp';
		</script>
		
		<%
		}else{
		%>
			<script>
			alert('없는 계정입니다..');
			location.href = '/login.jsp';
		</script>
		<%} %>
	
</body>
</html>