<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>공지사항</title>

<!-- /// <head> INCLUDE /// -->
<%@ include file="../common/header.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/subMenu.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/modalWindow.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<%
	final int ROWSIZE = 4;
	final int BLOCK = 5;

	int pg = 1;
	
	if(request.getParameter("pg")!=null) {
		pg = Integer.parseInt(request.getParameter("pg"));
	}
	
	int start = (pg*ROWSIZE) - (ROWSIZE-1);
	int end = (pg*ROWSIZE);
	
	int allPage = 0;
	
	int startPage = ((pg-1)/BLOCK*BLOCK)+1;
	int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK;

%>




<!-- <script>
$(document).ready(funtion()){
	$('table.boardList').each(function() {//반복문

	var currentPage = 0;
	var numPerPage = 5;
	var $table = $(this);
	
	$table.blind('boardList', function() {
	$table.find('td tr').hide();//기본적으로 모두 감춘다.
	slice(currentPage * numPerPage,
			(currentPage + 1) * numPerPage)
			.show();});
	
	var numRows = $table.find('td tr').length;
	//length로 전체길이구함
	var numPages = Math.ceil(numRows / numPerPage);
	//Math.ceil를 이용하여 반올림
	var $pager = $('<div class="pager">');
			
			//pager라는 클래스의 div엘리먼트 작성
			
			for (var page = 0; page < numPages; page++) {
			
			$('<span class="page-number"></span>').text(page + 1)
			.bind('click', {newPage: page}, function(event) {        
			currentPage = event.data['newPage'];
			$table.trigger('boardList');
			
			
			//for구문을 이용하여 페이지 수만큼
			
			//버튼을 구현
			
			$(this).addClass('active')
			
			//활성화된페이지에는 active라는 클래스명을 붙여준다.
			
			.siblings().removeClass('active');
			
			}).appendTo($pager).addClass('clickable');
			
			}  
			
			$pager.insertBefore($table)
			
			//앞서 설정한 페이지키를 삽입
			
			.find('span.page-number:first').addClass('active');
			
			});

	//현재페이지+1 곱하기 현재페이지까지 보여준다

	};   
	
	$table.find('th').removeClass('sorted-asc')
	
	.removeClass('sorted-desc');
	
	if (sortDirection == 1) {
	
	$header.addClass('sorted-asc');
	
	}
	
	else {
	
	$header.addClass('sorted-desc');
	
	}
	
	$table.alternateRowColors();
	
	
	$table.trigger('boardList ');     
	

</script>
 -->
</head>
<body>





	<!-- /// <header> INCLUDE /// -->
	<c:import url="../common/header2.jsp" />

	<article>
		<div id="wrap">
			<div class="menu">
				<ul>

					<li class="boardMenu"><a class="myPageMenu" href="#"
						OnClick="window.location='allList.do'">전체보기</a></li>
					<li class="boardMenu"><a class="myPageMenu" href="#"
						OnClick="window.location='eventList.do'">행사공지</a></li>
					<li class="boardMenu"><a class="myPageMenu" href="#"
						OnClick="window.location='systemList.do'">시스템공지</a></li>

					<c:choose>
						<c:when test="${member.permit =='ADMIN'}">
							<li class="boardMenu"><a class="myPageMenu" id="boardWrite" href="#"
								OnClick="window.location='write.do'">글쓰기</a></li>
							<li class="boardMenu"><a class="myPageMenu" href="#"
								OnClick="window.location='deleteList.do'">삭제된글</a></li>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div class="clear"></div>


			<div class="boardList">
				<dl>
					<c:forEach var="notice" items="${add}" varStatus="cnt">
						<dt class="listHead">
							<h3>${notice.title}</h3>
							<h5>${notice.formatUpdatedate}</h5>

						</dt>



						<dd class="listContent">${notice.issue}
						<c:choose>
						<c:when test="${member.permit =='ADMIN'}">
						<a class="mainBoard" href="#"
								OnClick="window.location='edit.do?notCD=${notice.notCD}'">글수정</a> <a
								class="mainBoard" href="#"
								OnClick="window.location='delete.do?notCD=${notice.notCD}'">삭제</a>
						
						</c:when>
						<c:otherwise>
						</c:otherwise>
						</c:choose>
						</dd>
					</c:forEach>


				</dl>
			</div>
			
			<div class>
			<dl>
			<c:forEach var="notice" items="${add}" varStatus="cnt">
			
			</c:forEach>
						
			</dl>
			<a href="#" class="listMore" onclick=>지난 공지사항 더보기</a>
			</div>
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
								<tr>
									<td width="5" />
									<td>글쓰기</td>
									<td width="5" />
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
									<td><form:select path="code" name="code" items="${code}"
											itemValue="code" itemLabel="codenm" style="width:50; align:center;" />

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
		
		  <tr align="center">
   <td><input type=button value="글쓰기" OnClick="window.location='write.jsp'"></td>
  </tr> 
</table>
					
					

				</table>
			</form>
		</div>
	</div>



	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는 jQuery 모음 ################---->
	<!----################ 여기부터는  jQuery 모음 ################---->
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
									($(document).scrollTop() + $("#overLayer").height() / 2)
											+ "px");
						});
			}
		});
	</script>


</body>
</html>