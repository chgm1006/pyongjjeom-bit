<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String emailAuthCD = (String) request.getParameter("emailAuthCD");
	String email = (String) request.getParameter("email");
	request.setAttribute("emailAuthCD", emailAuthCD);
	request.setAttribute("email", email);
	request.getRequestDispatcher("views/emailAuth_check.force").forward(
			request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 	<jsp:forward page="views/emailAuth_check.force"> --%>
	<%-- 		<jsp:param name="emailAuthCD" value="${emailAuthCD }" /> --%>
	<%-- 		<jsp:param name="email" value="${email }" /> --%>
	<%-- 	</jsp:forward> --%>
</body>
</html>