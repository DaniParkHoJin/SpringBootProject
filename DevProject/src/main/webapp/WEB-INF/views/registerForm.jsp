<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 테이터 처리 에너테이션</title>
</head>
<body>
	<h1>요청 데이터 처리 애너테이션
	</h1>
	<a href="register/hojin">register/hojin</a>
	<br>
	<a href="register/hojin/100">register/hojin/100</a>
	<br>
	<form action="/register01" method="post">
		userId: <input type="text" name="userId" value="hojin"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br> <input
			type="submit" value="register01">
	</form>
	<form action="/register02" method="post">
		userId: <input type="text" name="userId" value="hojin"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br> <input
			type="submit" value="register02">
	</form>
</body>
</html>