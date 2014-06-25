<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>공지사항</title>


<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board.css">

<script type="text/javascript">
	$(function() {
		$("dd").css("display", "none");
		$("dl dt,dl dt.selected").click(function() {
			if ($("+dd", this).css("display") == "none") {
				$("+dd", this).slideDown("fast");
				$("dt").removeClass("selected");
				$(this).addClass("selected");
			} else {
				$("+dd", this).slideUp("fast");
				$(this).removeClass("selected");
			}
		});
	});
</script>
</head>
<body>
	<div id="wrap">
		<div class="menu">
			<ul>
				<li class="boardMenu"><a class="myBoard" href="#">전체보기</a></li>
				<li class="boardMenu"><a class="friendBoard" href="#">행사공지</a></li>
				<li class="boardMenu"><a class="mainBoard" href="#">시스템공지</a></li>
				<li class="boardMenu"><a class="mainBoard" href="#" OnClick="window.location='write.do'">글쓰기</a></li>
			</ul>
		</div>
		<div class="clear"></div>


		<div class="boardList">
			<dl>
			<c:forEach var="notice" items="${add}" varStatus="cnt">
				<dt class="listHead">
					<h3>${notice.title}</</h3>
					<h4>${notice.regidate}</h4>
				</dt>
				<dd class="listContent">${notice.issue}<a class="mainBoard" href="#">글수정</a><br>
				<a class="mainBoard" href="#" OnClick="window.location='delete.do'">삭제</a></dd>
			</c:forEach>
			</dl>
		</div>
		<a href="#" class="listMore">지난 공지사항 더보기</a>
	</div>
	<div>

	</div>
	
</body>
</html>