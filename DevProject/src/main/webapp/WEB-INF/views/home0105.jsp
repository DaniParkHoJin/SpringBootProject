<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0105</title>
</head>
<body>
	<table border="1">
		<%-- 		<tr>
			<td>\${member.userId}</td>
			<td>${memberMap["userId"]}</td>
		</tr>
		<tr>
			<td>\${member.password}</td>
			<td>${memberMap["password"]}</td>
		</tr>
		<tr>
			<td>\${member.userName}</td>
			<td>${memberMap["userName"]}</td>
		</tr>
		<tr>
			<td>\${member.email}</td>
			<td>${memberMap["email"]}</td>
		</tr>
		<tr>
			<td>\${member.dateOfBirth}</td>
			<td>${memberMap["dateOfBirth"]}</td>
		</tr> --%>
		<tr>
			<td>member.userId</td>
			<td>${member.userId}</td>
		</tr>
		<tr>
			<td>member.userId</td>
			<td><c:out value="${member.userId}" /></td>
		</tr>
		<tr>
			<td>member.userId</td>
			<td><c:out value="${member.userId}" default="hongkd" /></td>
		</tr>



	</table>
</body>
</html>