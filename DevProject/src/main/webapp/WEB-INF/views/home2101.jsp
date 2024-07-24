<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home2101</title>
</head>
<body>
	<p>number : ${coin}</p>
	<p>
	currency : <fmt:formatNumber value="${coin}" type="currency" />
	</p>
	<p>
	percent : <fmt:formatNumber value="${coin}" type="percent" />
	</p>
	<p>
	pattern : <fmt:formatNumber value="${coin}" pattern="0000000.00" />
	</p>
</body>
</html>