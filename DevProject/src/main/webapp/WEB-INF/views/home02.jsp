<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form Home02</title>
</head>
<body>
	<h2>Spring Form</h2>
	<form:form modelAttribute="member" method="post" action="register">
		<table>
			<tr>
				<td>유저ID</td>
				<td><form:input path="userId" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>E-MAIL</td>
				<td><form:input path="email" /></td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>



	<!--<h1>Member Info.</h1>
<p>
	member.userId :
	<c:out value="${member.userId}"></c:out>
</p>
<p>member.password : ${member.password}.</p>
<p>member.userName : ${member.userName}.</p>
<p>member.email : ${member.email}.</p>
<p>member.dateOfBirth : ${member.dateOfBirth}.</p>
-->
</body>
</html>