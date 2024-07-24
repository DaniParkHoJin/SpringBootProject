<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String[] hobbyArray = { "Music", "Movie" };
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0601</title>
</head>
<body>
	<c:choose>
		<c:when test="${member.gender == 'M' }">
			<p>male</p>
		</c:when>
		<c:when test="${member.gender == 'F' }">
			<p>female</p>
		</c:when>
		<c:otherwise>
			<p>others</p>
		</c:otherwise>
	</c:choose>

</body>
</html>