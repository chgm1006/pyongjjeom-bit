<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- ########################################### -->
<!-- #################    탑   메  뉴     ################# -->
<!-- ########################################### -->
	<header>
		<div class="topMenu">
			<div class="leftMenu">
				<a href="#"><img src="${pageContext.request.contextPath}/resources/img/logo.jpg" class="logo" /></a>
				<ul>
					<li class="menu1"><a href="#">영화</a></li>
					<li class="menu2"><a href="#">도서</a></li>
					<li class="menu3"><a href="#">공연</a></li>
				</ul>
				<div class="search">
					<input type="text"><a href="#"><img class="magnifier"
						src="${pageContext.request.contextPath}/resources/img/magnifier.png"></a>
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

