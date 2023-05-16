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
  <link rel="stylesheet" href="/css/index.css" />
  <body>
    <div class="container">
    <%@include file="/user.jsp" %>
    <%@include file="/header.jsp" %>
      <div class="image-slider">
        <div class="image-slider-container">
          <div class="image-slider-item" style="margin: 0px">
            <h1>Responsive Web Templates</h1>
            <p>반응형 웹디자인, 더욱더 간편하게</p>
          </div>
          <div class="image-slider-item" style="margin: 0px">
            <h1>Responsive Web Templates</h1>
            <p>반응형 웹디자인, 더욱더 간편하게</p>
          </div>
          <div class="image-slider-item" style="margin: 0px">
            <h1>Responsive Web Templates</h1>
            <p>반응형 웹디자인, 더욱더 간편하게</p>
          </div>
          <div class="image-slider-item" style="margin: 0px">
            <h1>Responsive Web Templates</h1>
            <p>반응형 웹디자인, 더욱더 간편하게</p>
          </div>
          <div class="image-slider-item" style="margin: 0px">
            <h1>Responsive Web Templates</h1>
            <p>반응형 웹디자인, 더욱더 간편하게</p>
          </div>
          <div class="image-slider-item" style="margin: 0px">
            <h1>Responsive Web Templates</h1>
            <p>반응형 웹디자인, 더욱더 간편하게</p>
          </div>
        </div>
        <img
          onclick="moveImage('left')"
          id="left-arrow"
          src="/image/arrow-left.svg"
          alt=""
        />
        <img
          onclick="moveImage('right')"
          id="right-arrow"
          src="/image/arrow-right.svg"
          alt=""
        />
      </div>
      <div class="hover-menu">
        <div class="hover-menu-main">
          <div class="hover-menu-item">
            <div class="hover-menu-item-img">
              <img src="/image/alarm.svg" width="50px" height="50px" alt="" />
            </div>
            <h3 class="hover-menu-item-title">무료홈페이지</h3>
            <p class="hover-menu-item-article">
              무료 홈페이지로 부담없이 내사업을 펼친다
            </p>
          </div>
          <div class="hover-menu-item">
            <div class="hover-menu-item-img">
              <img src="/image/box.svg" width="50px" height="50px" alt="" />
            </div>
            <h3 class="hover-menu-item-title">반응형웹</h3>
            <p class="hover-menu-item-article">
              차세대 시스템 HTML5로 모든 디바이스를 하나로
            </p>
          </div>
          <div class="hover-menu-item">
            <div class="hover-menu-item-img">
              <img src="/image/magic.svg" width="50px" height="50px" alt="" />
            </div>
            <h3 class="hover-menu-item-title">pc&mobile</h3>
            <p class="hover-menu-item-article">
              어떤 pc나 mobile 에서도 똑같은 정보를 받아본다.
            </p>
          </div>
          <div class="hover-menu-item">
            <div class="hover-menu-item-img">
              <img src="/image/pencil.svg" width="50px" height="50px" alt="" />
            </div>
            <h3 class="hover-menu-item-title">맞춤형 제작</h3>
            <p class="hover-menu-item-article">
              나에게 맞는 홈페이지 구조를 쉽게 입히고 관리한다.
            </p>
          </div>
        </div>
      </div>
      <div class="bottom-menu">
        <div class="bottom-menu-main">
          <div class="bottom-menu-item table">
          <c:forEach var="item" items="${resultList}" begin="0" end="4" step="1" varStatus="status">
 				<ul class="board">
              <li><a href="/board/selectBoard.do?id=${item.id}">${item.subject}</a></li>
              <li>${item.regdate.split(" ")[0]}</li>
            </ul>
			</c:forEach>
          </div>
          <div class="bottom-menu-item enter">
            <div class="enter-intro-fonts">
              <h1>사업소개</h1>
              <p>
                인간의 환경을 생각하며<br />가치를 창조하는 회사,<br />더착한
              </p>
            </div>
          </div>
        </div>
      </div>
          <%@include file="/footer.jsp" %>
    </div>
  </body>
<script src="/js/slider.js"></script>
</html>