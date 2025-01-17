<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Home Page</title>
</head>
<body>
<h3>Home Page</h3>
<sec:authorize access="isAnonymous()">
    <a href="/login">로그인</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a href="/logout">로그아웃</a>
</sec:authorize>
</body>
</html>