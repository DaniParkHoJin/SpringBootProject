<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0203</title>
</head>
<body>
<c:set var="memberId">${member.userId}</c:set>
	<table border="1">
		<tr>
		<td>member.userId</td>
		<td>${memberId}</td>
		</tr>

<%-- 		<tr>
			<td>\${userId == "parkId"}</td>
			<td>${userId == "parkId"}</td>
		</tr>
		<tr>
			<td>\${userId == "parkId"}</td>
			<td>${userId eq "parkId"}</td>
		</tr> --%>
	</table>
</body>
</html>