<%@page import="org.apache.ibatis.executor.ReuseExecutor"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#main {
	background-color: #FAF4C0;
	border-top: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-left: 1px solid #333333;
	border-right: 1px solid #333333;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

  <c:forEach var="book" items="${resultList }" varStatus="status">
    <div id="main" onclick="document.location='test3.do?num=${status.index}' ">

      책 제목 : ${book.title}<br> <br> <a href="${book.link }"> <img src="${book.image}"></a><br> <br>
      저자 :${book.author }<br> <br> 출판사 :${book.publisher}<br> <br> 출간일 :${book.pubdate}<br> <br>
      정가 : ${book.price }<br> <br>
      <%-- 		할인 가격 :${book.discount}<br>
	 	 ISBN :${book.isbn}<br>
	 	 내용 :${book.description}<br>
 --%>
    </div>
    <br>
  </c:forEach>

</body>
</html>
