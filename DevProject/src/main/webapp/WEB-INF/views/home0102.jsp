<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0102</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>member.hobbyArray</td>
			<td><c:forEach var="hobby" items="${member.hobbyArray}"> 
${hobby} <br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>\${member.hobbyArray[0]}</td>
			<td>${member.hobbyArray[0]}</td>
		</tr>
		<tr>
			<td>\${member.hobbyArray[1]}</td>
			<td>${member.hobbyArray[1]}</td>
		</tr>
		<tr>
			<td>member.hobbyList</td>
			<td><c:forEach var="hobby" items="${member.hobbyList}"> 
${hobby} <br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>\${member.hobbyList[0]}</td>
			<td>${member.hobbyList[0]}</td>
		</tr>
		<tr>
			<td>\${member.hobbyList[1]}</td>
			<td>${member.hobbyList[1]}</td>
		</tr>

	</table>
</body>
</html>