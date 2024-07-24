<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home3302</title>
</head>
<body>
	<p>now : ${now}</p>
	<p>
		time :
		<fmt:formatDate value="${now}" type="time" />
	</p>
	<p>time default :</p>
	<p>
		<fmt:formatDate value="${now}" type="time" dateStyle="default" />
	</p>
	<p>
		time short :
		<fmt:formatDate value="${now}" type="time" dateStyle="short" />
	</p>
	<p>
		time medium :
		<fmt:formatDate value="${now}" type="time" dateStyle="medium" />
	</p>
	<p>
		time long :
		<fmt:formatDate value="${now}" type="time" dateStyle="long" />
	</p>
	<p>
		time full :
		<fmt:formatDate value="${now}" type="time" dateStyle="full" />
	</p>

</body>
</html>