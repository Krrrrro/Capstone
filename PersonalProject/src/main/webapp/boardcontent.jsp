<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.board.service.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="egovframework.ripple.service.RippleVO"%>
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
                  <div id="boardcontent"><c:out value="${board.ip}"/></div>
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
             
              <div id="ripple-div">
              <% List<RippleVO> rippleList = (List<RippleVO>) request.getAttribute("rippleList"); 
              	if(rippleList != null){
              		for(RippleVO item : rippleList){
              			%>
              			<div class="ripples" style="padding-left: <%=item.getReStep() * 50 %>px" <%	
              			%>>
                <div class="ripple-inform">
                  <span class="ripple-writer"><%=item.getWriter() %></span>
                  <span class="ripple-date"><%=item.getRegdate() %></span>
                </div>

                <div class="ripple-content">
                 	<%=item.getContent() %>
                </div>
                <div class="ripple-reply">
                  <a href="#">답글</a>
                </div>
              </div>
              			
              			
              			<%
              		}
              		
              	}
              %>
            </div>
            <div class="ripple-write-div">
              <div><strong>댓글작성</strong></div>
              <div class="ripple-input-div">
                <form action="">
                  <label for="">이름</label>
                  <input type="text" />
                  <label for="">비밀번호</label>
                  <input type="text" />
                  <textarea
                    name=""
                    id="ripple-content"
                    cols="30"
                    rows="5"
                    style="width: 100%"
                  ></textarea>
                  <button type="button" onclick="rippleSend()">작성하기</button>
                </form>
              </div>
            </div>
          </div>
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
  	
  	
	const rippleSend = () => {
		var content = $("#ripple-content").val();
		var writer = "작성자";
		var boardid = <%=vo.getId()%>
		saveJson(content, writer, boardid);
	}
  	
function saveJson(content, writer, boardid) {
	   $.ajax({
	       url:"/ripple/addRipple.do", //request 보낼 서버의 경로
	       type:'post', // 메소드(get, post, put 등)
	       data: {'content': content, 'writer' : writer, "boardId" : boardid},
	       dataType: "text",
	       async : false,
	       success: function(data) {
	    	   alert("성공했음");
	    	   $("#ripple-div").load("/rippleform.jsp");
	       },
	       error: function(err) {
	       }
	   });
	   
  }
  	
  	
  </script>
</html>