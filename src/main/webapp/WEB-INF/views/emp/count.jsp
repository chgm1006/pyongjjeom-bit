<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객의 수</title>
</head>
<body>
	고객의 수 : ${count}.
	<br>
	<%=new java.util.Date()%>
	<%=request.getAttribute("count")%>
	<%=session.getAttribute("count")%>
	<%=application.getAttribute("count")%>
</body>
</html>