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
<title>Home0701</title>
</head>
<body>
	<c:forEach var="hobby" items="${member.hobbyArray}">
		${hobby }<br>
	</c:forEach>

</body>
</html>