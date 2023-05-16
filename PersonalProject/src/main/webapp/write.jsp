<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.user.service.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="./css/write.css" />
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
            <div class="write-main">
              <div>
                <span>제목</span><input id="titleInput" style="width: 80%" type="text" />
              </div>
              <div>
                <span>내용</span>
                <textarea
                  name="writearea"
                  id="writearea"
                  cols="30"
                  rows="10"
                ></textarea>
              </div>
            </div>
            <div class="list-div"><a onclick="sendText()" style="cursor:pointer;">작성</a></div>
          </div>
        </div>
      </div>
      <%@include file="/footer.jsp" %>
    </div>
  </body>
  <script src="//cdn.ckeditor.com/4.21.0/standard/ckeditor.js"></script>
  <script>
    $(function () {
      CKEDITOR.replace("writearea", {
        filebrowserUploadUrl:
          "${pageContext.request.contextPath}/board/addImage.do",
        width: "80%",
        height: "300px",
      });
    });
    
    
    
    
    const sendText = () => {
    	var content = CKEDITOR.instances.writearea.getData();
    	var subject = $('#titleInput').val();
    	var text = content.replace(/[<][^>]*[>]/gi, "");
    	var onlytext = text.replace(/&nbsp;/gi, "");
    	var writer = '<%=user.getUsername()%>' + '';
    	var userid = '<%=user.getUserid()%>' + '';
    	
    	saveJson(content, subject, onlytext, writer, userid);
       
    };
    
    function saveJson(content, subject, onlytext, writer, userid) {
  	   $.ajax({
  	       url:"/board/addBoardView.do", //request 보낼 서버의 경로
  	       type:'post', // 메소드(get, post, put 등)
  	       data: {'content': content, 'subject' : subject, 'onlytext' : onlytext, 'writer' : writer, 'userid' : userid},
  	       dataType: "text",
  	       async : false,
  	       success: function(data) {
  	    	 location.href = '/board/BoardList.do'
  	       },
  	       error: function(err) {
  	    	   location.href = '/board/BoardList.do'
  	       }
  	   });
  	   
    }
    
    function showReply(re_step){
    	window.open("/showReply.html?re_step=" + re_step,"네이버","width=500,height=500,top=100,left=100")
    }
  </script>
</html>