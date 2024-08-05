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
    <title>트랜잭션</title>
</head>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h3>회원 등록</h3>
<form:form modelAttribute="member" action="register">
    <table>
        <tr>
            <td>userid</td>
            <td><form:input path="userId"/></td>
            <td><font color="red"><form:errors path="userId"/></font></td>
        </tr>
        <tr>
            <td>userpw</td>
            <td><form:input path="userPw"/></td>
            <td><font color="red"><form:errors path="userPw"/></font></td>
        </tr>
        <tr>
            <td>username</td>
            <td><form:input path="userName"/></td>
            <td><font color="red"><form:errors path="userName"/></font></td>
        </tr>
    </table>
    <div>
        <input type="submit" value="Submit"/>
        <input type="reset" , value="Reset"/>
    </div>
    <a href="list">List</a>
</form:form>
</body>
</html>