<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home2201</title>
</head>
<body>
	<p>number : ${coin}</p>
	<fmt:parseNumber value="${coin}" var="coinNum"/>
	<p>coinNum : ${coinNum}</p>
</body>
</html>