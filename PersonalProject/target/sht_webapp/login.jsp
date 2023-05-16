<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.board.service.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <link rel="stylesheet" href="/css/bootstrap.css" />
  <link rel="stylesheet" href="/css/write.css" />
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
  <body>
    <div class="container">
        <%@include file="/user.jsp" %>
         <%@include file="/header.jsp" %>
      </div>
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
              <h1>로그인</h1>
            </div>
            <form
              style="width: 500px; margin: 0 auto"
              action="/user/checkUser.do"
            >
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label"
                  >아이디</label
                >
                <input
                  type="text"
                  class="form-control"
                  id="exampleInputEmail1"
                  name="userid"
                />
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label"
                  >비밀번호</label
                >
                <input
                  type="password"
                  class="form-control"
                  id="exampleInputPassword1"
                  name="userpwd"
                />
              </div>
              <button type="submit" class="btn btn-primary">로그인</button>
            </form>
            <div
              style="
                margin: 0 auto;
                text-align: center;
                margin-top: 20px;
                font-size: 12px;
              "
            >
              아이디가 없으십니까?
              <a style="color: purple" href="#">회원가입</a> 하러가기
            </div>
          </div>
        </div>
      </div>
      <%@include file="/footer.jsp" %>
    </div>
  </body>
</html>