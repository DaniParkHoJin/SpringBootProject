<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0901</title>
</head>
<body>
	<h4>절대 URL</h4>
	<c:import url="http://localhost:8080/boardjstl/list" />
	
	<c:import url="http://localhost:8080/boardjstl/search">
		<c:param name="keyword" value="orange" />
	</c:import>

	<h4>상대 URL - 절대 경로</h4>
	<c:import url="/boardjstl/list" />
	<c:import url="/boardjstl/search">
		<c:param name="keyword" value="orange" />
	</c:import>

	<h4>상대 URL - 상대 경로</h4>
	<c:import url="./boardjstl/list.jsp" />
	<c:import url="../views/boardjstl/list.jsp"></c:import>
</body>
</html>