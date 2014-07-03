<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <% session.removeAttribute("member");%> <!-- member이름으로 가져온 세션 삭세 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
로그아웃되었습니다.
<a href = "login.do">로그인하러가기</a>
<a href = "movieIndex.do">메인으로</a>
</body>
</html>