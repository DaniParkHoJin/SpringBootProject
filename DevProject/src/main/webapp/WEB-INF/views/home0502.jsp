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
<title>Home0502</title>
</head>
<body>
	<c:if test="${member.foreigner}">
	<p>member.foreigner == true</p>
	</c:if>
	
</body>
</html>