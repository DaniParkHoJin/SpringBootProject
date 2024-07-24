<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home1102</title>
</head>
<body>
	<h4>상대 URL - 절대 경로</h4>
	<c:redirect url="/boardjstl/list" />
	<h4>redirect 이후의 코드는 실행되지 않는다.</h4>
</body>
</html>