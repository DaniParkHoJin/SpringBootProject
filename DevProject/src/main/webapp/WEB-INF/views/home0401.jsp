<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0401</title>
</head>
<body>
	<%-- <table border="1">
		<tr>
<td>\${coin == 1000 && userId == "parkId"}</td> 
<td>${coin == 1000 && userId == "parkId"}</td>
</tr> 
<tr>
<td>\${coin == 1000 and userId eq "parkId"}</td> 
<td>${coin == 1000 and userId eq "parkId"}</td>
</tr> 
<tr>
<td>\${not empty member && userId eq "parkId"}</td> 
<td>${not empty member && userId eq "parkId"}</td>
</tr> 
<tr>
<td>\${! empty member && userId eq "parkId"}</td> 
<td>${! empty member && userId eq "parkId"}</td>
</tr>
	</table> --%>
	<c:catch var="ex">
${member.hobbyArray[3]}</c:catch>
	<p>
		<c:if test="${ex != null}">
${ex}
</c:if>
	</p>
</body>
</html>