<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form2 입력 화면</title>
</head>
<body>
	<h2>Spring Form 입력 화면</h2>
	<!-- modelAttribute 속성에 폼 객체의 속성명을 지정한다. -->
	<form:form modelAttribute="user" method="post" action="register">
		<table>
			<tr>
				<td>유저ID</td>
				<td><form:input path="userId" /><font color="red"><form:errors
							path="userId" /></font></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="userName" /><font color="red"><form:errors
							path="userName" /></font></td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>