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

<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/board.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/subMenu.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/modalWindow.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>



</head>
<body>


<!-- /// <header> INCLUDE /// -->
<c:import url="../common/header2.jsp"/>

<article>
	<div id="wrap">
		<div class="menu">
			<ul>
			
				<li class="boardMenu"><a class="myPageMenu" href="#" OnClick="window.location='allList.do'">전체보기</a></li>
				<li class="boardMenu"><a class="myPageMenu" href="#" OnClick="window.location='eventList.do'">행사공지</a></li>
				<li class="boardMenu"><a class="myPageMenu" href="#" OnClick="window.location='systemList.do'">시스템공지</a></li>
				<li class="boardMenu"><a class="myPageMenu" id="boardWrite" href="#" OnClick="window.location='write.do'">글쓰기</a></li>
				<li class="boardMenu"><a class="myPageMenu" href="#" OnClick="window.location='deleteList.do'">삭제된글</a></li>	
			</ul>
		</div>
		<div class="clear"></div>
		

		<div class="boardList">
			<dl>
			<c:forEach var="notice" items="${add}" varStatus="cnt">
				<dt class="listHead">
					<h3>${notice.title}</h3>
					<h5>${notice.updatedate}</h5>
				</dt>
			
				<dd class="listContent">${notice.issue}<a class="mainBoard" href="#" OnClick="window.location='edit.do?notCD=${notice.notCD}'">글수정</a>
				<a class="mainBoard" href="#" OnClick="window.location='delete.do?notCD=${notice.notCD}'">삭제</a></dd>
			</c:forEach>
	
			
			</dl>
		</div>
		<a href="#" class="listMore">지난 공지사항 더보기</a>
	</div>
</article>


<!---- 검은 바탕 ---->
	<div id='glayLayer'></div>
	
<!---- above page 시작 ---->	
	<div id='overLayer'>
		<div class="abc">
				<form name=writeform method=POST action="write_ok.do">
		<table>

			<tr>
				<td>
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr
							style="background: url('img/table_mid.gif') repeat-x; text-align: center;">
							<td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
							<td>글쓰기</td>
							<td width="5"><img src="img/table_right.gif" width="5" height="30" /></td>
						</tr>
					</table>
					<table>
						<tr>
							<td>&nbsp;</td>
							<td align="center">제목</td>
							<td><input name="title" size="50" maxlength="100"></td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">이름</td>
							<td><input name="writer" size="50" maxlength="50"></td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">비밀번호</td>
							<td><input name="notPasswd" size="50" maxlength="50"></td>
							<td>&nbsp;</td>
						</tr>


						<tr>
							<td>&nbsp;</td>
							<td align="center">카테고리</td>
							<td>	<form:select path="code" name="code" items="${code}" itemValue="code"
							itemLabel="codenm" style="width:50; align:center;"/>

							</td>
						</tr>
<%-- 
						<form:select path="code" name="code" items="${code}" itemValue="code"
							itemLabel="codenm" />
 --%>





						<%-- <tr>
					<td width="96">공지사항코드</td>
					<td width="172">
					
					<form:select path="code">
							<c:forEach var="codenm" items="${code}">
								<option value="${codenm.NO}">공지사항</option>
								<option value="${codenm.SM}">시스템점검</option>
								<option value="${codenm.EV}">이벤트</option>
					</c:forEach>
						</form:select></td>
				<tr height="20">
					<td width="96"></td>
					<td width="172"></td>
				</tr> --%>

						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">내용</td>
							<td><textarea name="issue" cols="50" rows="13"></textarea></td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr height="1" bgcolor="#82B5DF">
							<td colspan="4"></td>
						</tr>
						<tr align="center">
							<td>&nbsp;</td>

							<td colspan="2"><input type=button value="등록"
								OnClick="javascript:writeCheck();"> <input type=button
								value="취소" OnClick="javascript:history.back(-1)">
							<td>&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>

		</table>
		</form>
		</div>
	</div>



<!----################ 여기부터는 jQuery 모음 ################---->
<!----################ 여기부터는 jQuery 모음 ################---->
<!----################ 여기부터는 jQuery 모음 ################---->
<!---jQuery 아코디언--->


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
<!--------- 모달윈도우 : 컨텐츠 상세 -------->
<script type="text/javascript">
	$(function() {
		$("#glayLayer").click(function() {
			$(this).hide();
			$("#overLayer").hide();
		});

		$("a#boardWrite").click(function() {
			$("#glayLayer").show();
			$("#overLayer").fadeIn("Fast");
			return false;
		});
		$(".exit").click(function() {
			$("#glayLayer").hide()
			$("#overLayer").hide();
		});

		if ($.browser.msie && $.browser.version < 7) {
			$(window).scroll(
					function() {
						$("#glayLayer").css('top', $(document).scrollTop());
						$("#overLayer").css(
								'top',
								($(document).scrollTop() + $("#overLayer")
										.height() / 2)
										+ "px");
					});
		}
	});
</script>


</body>
</html>