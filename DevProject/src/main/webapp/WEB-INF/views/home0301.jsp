<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0301</title>
</head>
<body>
	<c:set var="memberId" value="${member.userId}" />
	<table border="1">
		<tr>
			<%-- 	<td>\${empty member}</td>
			<td>${empty member}</td>
		</tr>
		<tr>
			<td>\${empty member.userId}</td>
			<td>${empty member.userId}</td>
		</tr> --%>
		<tr>
			<td>member.userId</td>
			<td>${memberId}</td>
		</tr>
		<c:remove var="memberId" />
		<table border="1">
			<tr>
				<td>member.userId</td>
				<td>${memberId}</td>
			</tr>
		</table>
</body>
</html>