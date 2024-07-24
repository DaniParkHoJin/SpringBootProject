<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home3301</title>
</head>
<body>
	<p>now : ${now}</p>
	<p>
		date :
		<fmt:formatDate value="${now}" type="date" />
	</p>
	<p>date default :</p>
	<p>
		<fmt:formatDate value="${now}" type="date" dateStyle="default" />
	</p>
	<p>
		date short :
		<fmt:formatDate value="${now}" type="date" dateStyle="short" />
	</p>
	<p>
		date medium :
		<fmt:formatDate value="${now}" type="date" dateStyle="medium" />
	</p>
	<p>
		date long :
		<fmt:formatDate value="${now}" type="date" dateStyle="long" />
	</p>
	<p>
		date full :
		<fmt:formatDate value="${now}" type="date" dateStyle="full" />
	</p>

</body>
</html>