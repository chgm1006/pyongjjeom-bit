<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script language="javascript">
	// 자바 스크립트 시작

	function writeCheck() {
		var form = document.writeform;

		if (!form.title.value) {
			alert("제목을 적어주세요");
			form.title.focus();
			return;
		}

		if (!form.writer.value) // form 에 있는 name 값이 없을 때
		{
			alert("이름을 적어주세요"); // 경고창 띄움
			form.writer.focus(); // form 에 있는 name 위치로 이동
			return;
		}

		if (!form.notPasswd.value) {
			alert("비밀번호를 적어주세요");
			form.notPasswd.focus();
			return;
		}

		if (!form.issue.value) {
			alert("내용을 적어주세요");
			form.issue.focus();
			return;
		}

		form.submit();
	}
</script>


<body>
	<form name=writeform method=POST action="edit_ok.do">
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
						
						
						<form:select path="code" name="code" items="${code}" itemValue="code" 						
						itemLabel="codenm" />
						
					
					
		
		
		
		
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

							<td colspan="2"><input type=button value="수정"
								OnClick="javascript:writeCheck();"> <input type=button
								value="취소" OnClick="javascript:history.back(-1)">
							<td>&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>