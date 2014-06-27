<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>공지사항</title>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp" %>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board.css">


</head>
<body>


<!-- /// <header> INCLUDE /// -->
<c:import url="../common/header2.jsp"/>

<article>
	<div id="wrap">
		<div class="menu">
			<ul>
				<li class="boardMenu"><a class="myBoard" href="#" OnClick="window.location='allList.do'">전체보기</a></li>
				<li class="boardMenu"><a class="friendBoard" href="#" OnClick="window.location='eventList.do'">행사공지</a></li>
				<li class="boardMenu"><a class="mainBoard" href="#" OnClick="window.location='systemList.do'">시스템공지</a></li>
				<li class="boardMenu"><a class="mainBoard" href="#" OnClick="window.location='write.do'">글쓰기</a></li>
			</ul>eventList.do
		</div>
		<div class="clear"></div>


		<div class="boardList">
			<dl>
			<c:forEach var="notice" items="${add}" varStatus="cnt">
				<dt class="listHead">
					<h3>${notice.title}</h3>
					<h4>${notice.updatedate}</h4>
				</dt>
			
				<dd class="listContent">${notice.issue}<a class="mainBoard" href="#" OnClick="window.location='edit.do?notCD=${notice.notCD}'">글수정</a>
				<a class="mainBoard" href="#" OnClick="window.location='delete.do?notCD=${notice.notCD}'">삭제</a></dd>
			</c:forEach>
	
			
			</dl>
		</div>
		<a href="#" class="listMore">지난 공지사항 더보기</a>
	</div>

<!-- /// <jQuery> INCLUDE /// -->
<c:import url="../../../resources/js/boardList.js"/>


</body>
</html>