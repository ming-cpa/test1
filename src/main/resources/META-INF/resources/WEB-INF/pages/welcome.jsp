<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page language="java" import="sample.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h3><c:out value="${servername}"/> Welcome page</h3>
<h3>User Name :<c:out value="${usr.username}"/></h3>
<h3>Dept :<c:out value="${usr.dept}"/></h3>
<h3>Session:<c:out value="${usr.sID}"/></h3>
<h3><c:out value="${msg}"/></h3>
<body>
</body>
