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
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
  <link rel="stylesheet" href="/css/header.css" />
  <body>
      <div class="header">
        <div class="header-main">
          <a href="/index.do" class="title-link">
            <img src="/image/logo11558341581.png" width="100%" alt="" />
          </a>
          <div class="navbar">
            <span class="navbar-item">
              <a href="#" id="event-navbar">회사소개</a>
              <div class="detail-navbar">
                <a href="#">인사말</a>
                <a href="">개요</a>
                <a href="">오시는 길</a>
              </div>
            </span>
            <span class="navbar-item">
              <a href="#" id="event-navbar">사업소개</a>
              <div class="detail-navbar">
                <a href="#">사업소개</a>
              </div>
            </span>

            <span class="navbar-item">
              <a href="#" id="event-navbar">제품소개</a>
              <div class="detail-navbar">
                <a href="#">제품소개</a>
              </div>
            </span>
            <span class="navbar-item">
              <a href="#" id="event-navbar">견적소개</a>
              <div class="detail-navbar">
                <a href="#">견적문의</a>
              </div>
            </span>
            <span class="navbar-item">
              <a href="#" id="event-navbar">고객센터</a>
              <div class="detail-navbar">
                <a href="/board/BoardList.do">공지사항</a>
                <a href="">질문과 답변</a>
                <a href="">갤러리</a>
                <a href="">동영상</a>
              </div>
            </span>
          </div>
        </div>
      </div>

  </body>
</html>