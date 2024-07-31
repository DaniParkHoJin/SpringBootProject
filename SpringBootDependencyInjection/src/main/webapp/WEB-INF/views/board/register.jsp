<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Board</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(() => {
		let formObj = $("#board");
		$("#btnRegister").on("click", ()=>{
			formObj.attr("action","/board/register");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", ()=> {
			self.location = "/board/list";
		});
	});
</script>
<body>
	<h2>REGISTER</h2>
<form:form modelAttribute="board" action="register">
	<table>
		<tr>
			<td>Title</td>
			<td><form:input path="title"/></td>
			<td><font color="red"><form:errors path="title"/></font></td>
		</tr>
		<tr>
			<td>Writer</td>
			<td><form:input path="writer"/></td>
			<td><font COLOR="red"><form:errors path="writer"/></font></td>
		</tr>
		<tr>
			<td>Content</td>
			<td><form:textarea path="content"/></td>
			<td><font color="red"><form:errors path="content"/></font> </td>
		</tr>

	</table>
</form:form>
<div>
	<button type="submit" id="btnRegister">Register</button>
	<button type="submit" id="btnList">List</button>
</div>
</body>
</html>