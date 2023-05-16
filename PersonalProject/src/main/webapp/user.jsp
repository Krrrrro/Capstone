<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="egovframework.user.service.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/css/user.css" />
<body>
	<div class="user-div">
      <div class="user-main">
      <%
      	UserVO user = (UserVO) session.getAttribute("user");
     	 
      if(user == null) {%>
        <a href="/login.jsp">로그인</a>
        <a href="/signup.jsp">회원가입</a>
        <%}else{
        	
        	%>
        <a href="/logout.jsp">로그아웃</a>
        <a href="/modify.jsp">회원수정</a>
        <%} %>
      </div>
    </div>
</body>
</html>