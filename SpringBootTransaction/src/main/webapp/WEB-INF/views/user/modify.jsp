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
<body>
<h3>회원 정보 수정</h3>
<form:form modelAttribute="member" action="modify">
    <form:hidden path="userNo"/>
    <table>
        <tr>
            <td>userid</td>
            <td><form:input path="userId" readonly="true"/></td>
            <td><font color="red"><form:errors path="userId"/></font></td>

        </tr>
        <tr>
            <td>username</td>
            <td><form:input path="userName"/></td>
            <td><font color="red"><form:errors path="userName"/></font></td>
        </tr>
        <tr>
            <td>auth</td>
            <td>
                <form:select path="auth">
                    <form:option value="" label="=== 선택해주세요 ==="/>
                    <form:option value="ROLE_USER" label="사용자"/>
                    <form:option value="ROLE_MEMBER" label="회원"/>
                    <form:option value="ROLE_ADMIN" label="관리자"/>
                </form:select>
            </td>
            <td><font color="red"><form:errors path="auth"/></font></td>
        </tr>
    </table>
    <div>
        <input type="submit" value="Submit"/>
    </div>
    <a href="list">List</a>
</form:form>
</body>
</html>