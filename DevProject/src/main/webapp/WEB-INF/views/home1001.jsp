<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home1001</title>
</head>
<body>
	<h4>절대 URL</h4>
	<c:url value="http://localhost:8080/boardjstl/list" />

	<h4>상대 URL - 절대 경로</h4>
	<c:url value="/boardjstl/list" />

	<h4>상대 URL - 상대 경로</h4>
	<c:url value="./boardjstl/list" />
</body>
</html>