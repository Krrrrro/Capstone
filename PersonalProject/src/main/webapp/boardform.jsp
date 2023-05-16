<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.board.service.BoardVO"%>
<%@ page import="egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <link rel="stylesheet" href="/css/board.css" />
<body>
	<div class="board-table">
                <table>
                  <thead>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                  </thead>
                  <tbody>
                   <c:forEach var="item" items="${resultList}" begin="0" end="10" step="1" varStatus="status">
		 			<tr>
                      <td>${item.id}</td>
                      <td class="subject">
                        <a href="/board/selectBoard.do?id=${item.id}">${item.subject}</a>
                      </td>
                      <td>${item.writer}</td>
                      <td>${item.regdate.split(" ")[0]}</td>
                      <td>${item.views}</td>
                    </tr>
					</c:forEach>
                  </tbody>
                </table>
                 <div class="pageindex" style="text-align: center; margin: 80px 0">
              <% PaginationInfo search = (PaginationInfo) session.getAttribute("paginationInfo");
              	if(search != null){
              		for(int i = 0; i < search.getTotalPageCount(); i++){
              			%>
              			<a href="/board/BoardList.do?pageIndex=<%=i + 1%>" 
              			<%= i == search.getCurrentPageNo() - 1 ? "class=selected-page" : "" %>
              			><%=i+1 %></a>
              			
              			
              			<%
              		}
              	}
              %>
              </div>
</body>
</html>