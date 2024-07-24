<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home3303</title>
</head>
<body>
	<p>now : ${now}</p>
	<p>
		both :
		<fmt:formatDate value="${now}" type="both" />
	</p>
	<p>both default default :</p>
	<p>
		<fmt:formatDate value="${now}" type="both" dateStyle="default" />
	</p>
	<p>
		both short short :
		<fmt:formatDate value="${now}" type="both" dateStyle="short" />
	</p>
	<p>
		both medium medium :
		<fmt:formatDate value="${now}" type="both" dateStyle="medium" />
	</p>
	<p>
		both long long :
		<fmt:formatDate value="${now}" type="both" dateStyle="long" />
	</p>
	<p>
		both full full :
		<fmt:formatDate value="${now}" type="both" dateStyle="full" />
	</p>

</body>
</html>