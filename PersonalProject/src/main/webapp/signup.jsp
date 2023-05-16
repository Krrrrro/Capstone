<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="/css/bootstrap.css" />
  <link rel="stylesheet" href="./css/write.css" />
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
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
              <h1>회원가입</h1>
            </div>
            <form
              style="width: 500px; margin: 0 auto"
              name="joinfrm"
              action="/user/addUser.do"
            >
              <div class="mb-3">
                <label for="name" class="form-label">이름</label>
                <input
                  type="text"
                  class="form-control"
                  id="name"
                  name="username"
                  required
                />
              </div>
              <div class="mb-3">
                <label for="id" class="form-label">아이디</label>
                <input type="text" class="form-control" id="id" name="userid" required />
                <button type="button" class="btn btn-primary" id="checkIdBtn">
                  중복체크
                </button>
              </div>
              <div class="mb-3">
                <label for="pw" class="form-label">비밀번호</label>
                <input
                  type="password"
                  class="form-control"
                  id="pw"
                  name="userpwd"
                  required
                />
                <div id="pwCheckView" class="form-text">
                  비밀번호는 8자리~20자리 영문자, 숫자, 특수문자를
                  포함해야합니다.
                </div>
              </div>
              <div class="mb-3">
                <label for="pwCheck" class="form-label">비밀번호 확인</label>
                <input
                  type="password"
                  class="form-control"
                  id="pwCheck"
                  required
                />
                <div id="pwCheckedView" class="form-text">필수 입력</div>
              </div>
              <div class="mb-3">
                <label for="address" class="form-label">주소</label>
                <input
                  type="text"
                  class="form-control"
                  id="address"
                  name="useraddress"
                  required
                />
              </div>
              <button
                type="button"
                onclick="joinUser()"
                class="btn btn-primary"
              >
                회원가입
              </button>
            </form>
          </div>
        </div>
      </div>
      <%@include file="/footer.jsp" %>
    </div>
  </body>
    <script src="/js/join.js"></script>
</html>