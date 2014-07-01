<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ContentsSearch.do" method="get" id="frmLogin" name="frmLogin">
		<select name="category">
			<option value="book">책 
			<option value="movie">영화
		</select> 
		<input type="text" id="Search" name="Search">
		<input type="hidden"  name="stat" value="posting">
				<input type="submit" value="검색">
	
			</form>
</body>
</html>