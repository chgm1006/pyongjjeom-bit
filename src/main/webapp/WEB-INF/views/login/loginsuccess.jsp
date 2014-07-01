<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인완료

 현재 로그인 한사람 ${member.email}<br>
비번 ${member.passwd }<br>
<a href = "${pageContext.request.contextPath}/index.jsp">메인</a>
<a href = "myRoom.do">마이룸으로 이동</a>
<a href = "logout.do">로그아웃</a>
</body>
</html>