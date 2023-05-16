<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.board.service.BoardVO"%>
<%@ page import="egovframework.user.service.UserVO"%>
<%@ page import="egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
  <link rel="stylesheet" href="/css/board.css" />
  <body>
  
    <div class="container">
        <%@include file="/user.jsp" %>
        <%@include file="/header.jsp" %>
      <div class="subtitle">
        <div class="subtitle-main">
          <h1>Better than</h1>
          <h1 style="color: black; font-weight: 700">BUSINESS STORY</h1>
        </div>
      </div>
      <div class="content">
        <div class="main-content">
          <div class="menubar">
            <div>
              <a href="#">공지사항</a>
            </div>
            <div>
              <a href="#">질문과 답변</a>
            </div>
            <div>
              <a href="#">갤러리</a>
            </div>
            <div>
              <a href="#">동영상</a>
            </div>
          </div>
          <div class="board-div">
            <div class="board-title">
              <h1>공지사항</h1>
            </div>
            <div class="board-main">
              <div class="board-select">
              <% if(user != null){%>
                <a href="/write.jsp" style="margin-right: 10px">작성</a>
                <%} %>
                <a>검색 <i></i> </a>
              </div>
              <div class="board-input">
                <fieldset>
                  <input id="boardSearchInput" type="text" maxlength="30" placeholder="검색어" />
                  <button onclick="searchBoards();" style="cursor:pointer;"></button>
                </fieldset>
              </div>
              <div class="board-table" id="board-table">
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
              <% PaginationInfo search = (PaginationInfo) request.getAttribute("paginationInfo");
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
              </div>
             
            </div>
          </div>
        </div>
      </div>
      <%@include file="/footer.jsp" %>
    </div>
    <script>
    	const pagemove = (n) => {
    		location.href = '/board/BoardList.do?pageIndex=' + n;
    	}
    	
      	function searchBoards() {
      		var keyword = $('#boardSearchInput').val();
      		if(keyword == null){
      			return;
      		}
      		
      	   $.ajax({
      	       url:"/board/searchBoardList.do", //request 보낼 서버의 경로
      	       type:'post', // 메소드(get, post, put 등)
      	       data: {'searchKeyword': keyword}, //보낼 데이터
      	       dataType: "text",
      	       async : false,
      	       success: function(data) {
      	          	$("#board-table").load("/boardform.jsp");
      	       },
      	       error: function(err) {
      	           //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
      	           objErr = err;
      	          	alert("오류발생 , error="+err.state());
      	       }
      	   });
      };
    </script>
  </body>
</html>