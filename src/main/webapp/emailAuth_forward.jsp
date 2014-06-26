<%@page import="com.pyongjjeom.common.CommonAES"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String emailAuthCD = (String) request.getParameter("rootc");
	String email = (String) request.getParameter("rootm");

	CommonAES aes = new CommonAES();
	emailAuthCD = aes.getDecryptor(emailAuthCD);
	email = aes.getDecryptor(email);

	String forwardJSP = "views/emailAuth_check.force?emailAuthCD="
			+ emailAuthCD + "&email=" + email;
	request.getRequestDispatcher(forwardJSP).forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
</body>
</html>