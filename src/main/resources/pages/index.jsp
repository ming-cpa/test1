<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:out value="${pageContext.session.id}"/> --%>
	<!-- <form action="/welcome"> -->
	<form>
		<h1>This is <c:out value="${servername}"/></h1>
		<h1>This is <%=request.getAttribute("servername") %></h1>
		
		input：<input type="text" name="userName" /> <input type="submit"
			value="submit" /> <br />
	</form>
</body>
</html>