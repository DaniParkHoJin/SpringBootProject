<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0801</title>
</head>
<body>
	<c:forTokens var="hobby" items="${member.hobby }" delims=",">
	${hobby }<br>
	</c:forTokens>
</body>
</html>