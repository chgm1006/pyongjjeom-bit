<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.removeAttribute("member");
%>
<!-- member이름으로 가져온 세션 삭세 -->

<!DOCTYPE html>
<html>
<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	
	location.href = "movieIndex.do";
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>