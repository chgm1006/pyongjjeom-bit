<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- ########################################### -->
<!-- #################    탑   메  뉴     ################# -->
<!-- ########################################### -->
<header>
	<div class="topMenu">
		<div class="leftMenu">
			<a href="${pageContext.request.contextPath}/index.jsp"><img
				src="${pageContext.request.contextPath}/resources/img/logo.jpg" class="logo" /></a>
			<ul>
				<li class="menu1"><a href="#">영화</a></li>
				<li class="menu2"><a href="#">도서</a></li>
				<li class="menu3"><a href="#">공연</a></li>
			</ul>
			<div class="search">
				<form action="views/ContentsSearch.do" method="get" id="frmLogin"
					name="frmLogin">
					<select name="category">
						<option value="book">책
						<option value="movie">영화
					</select> <input type="text" id="Search" name="Search"> <input type="hidden"
						name="stat" value="search"> <input type="submit" value="검색">

				</form>
				<img class="magnifier"
					src="${pageContext.request.contextPath}/resources/img/magnifier.png">
			</div>
		</div>


		<div class="rightMenu">
			<ul>
				<li class="menu5"><a href="myroom.html" class="menu5_1">마이룸</a></li>
				<li class="menu6"><a href="#" class="menu6_1">친구들</a></li>
				<li class="menu7"><a href="views/boardList.do" class="menu7_1">공지사항</a></li>
			</ul>
		</div>
	</div>
</header>

