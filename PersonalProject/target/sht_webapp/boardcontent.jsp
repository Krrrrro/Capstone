<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.board.service.BoardVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <link rel="stylesheet" href="/css/boardcontent.css" />
  <body>
  <%BoardVO vo = (BoardVO) request.getAttribute("board"); %>
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
              <div class="board-content">
				                <h1 class="board-content-title">
                  	<c:out value="${board.subject}"/>
                </h1>
                <div class="board-informs">
                  <div><c:out value="${board.writer}"/></div>
                  <div><c:out value="${board.regdate}"/></div>
                  <div><i></i><c:out value="${board.views}"/></div>
                  <div><c:out value="${board.ip}"/></div>
                </div>
                <div class="board-main-content">
                  <%=vo.getContent()  %>
                </div>
              </div>
            </div>
            <div class="list-div"><a href="/board/BoardList.do">목록</a>
            <%if(user != null && user.getUserid().equals(vo.getUserid())){ %>
             <a href="/board/deleteBoard.do?id=<%=vo.getId()%>">삭제</a>
             <a href="/board/moveUpdatepage.do?id=<%=vo.getId()%>">수정</a>
             <%} %></div>
          </div>
        </div>
      </div>
     <%@include file="/footer.jsp" %>
    </div>
  </body>
  <script>
  	const removeBoard = (id) => {
  		location.href = '/board/deleteBoard.do?id=' + id;
  	}
  </script>
</html>