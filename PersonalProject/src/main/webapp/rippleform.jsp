<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.ripple.service.RippleVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
              <div id="ripple-div">
              <c:forEach var="ripple" items="${rippleList}" varStatus="status">
		 		<div class="ripples">
                <div class="ripple-inform">
                  <span class="ripple-writer">${ripple.writer}</span>
                  <span class="ripple-date">${ripple.regdate}</span>
                </div>

                <div class="ripple-content">
                  ${ripple.content}
                </div>
                <div class="ripple-reply">
                  <a href="#">답글</a>
                </div>
              </div>
			</c:forEach>
			</div>
</body>
</html>