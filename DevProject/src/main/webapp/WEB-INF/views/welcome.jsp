<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨트롤러에서 메시지 소스 사용</title>
</head>
<body>
	<h1>${message }<br>
	
	</h1>
	
	
	<P>The time on the server is ${serverTime}.</P>
</body>
</html>