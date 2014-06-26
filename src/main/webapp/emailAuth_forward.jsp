<%@page import="com.pyongjjeom.common.CommonAES"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String emailAuthCD = (String) request.getParameter("rootc");
	String email = (String) request.getParameter("rootm");
	System.out.println("emailAuthCD = " + emailAuthCD);
	System.out.println("email = " + email);

	CommonAES aes = new CommonAES();
	emailAuthCD = aes.getDecryptor(emailAuthCD);
	email = aes.getDecryptor(email);

	// 	System.out.println("emailAuthCD = " + emailAuthCD);
	// 	System.out.println("email = " + email);

	request.setAttribute("emailAuthCD", emailAuthCD);
	request.setAttribute("email", email);
	request.getRequestDispatcher("views/emailAuth_check.force").forward(
			request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
</body>
</html>