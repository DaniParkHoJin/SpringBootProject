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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<body>
<h3>회원 목록</h3>
<a href="/user/register">New</a>
<table border="1">
    <tr>
        <th align="center" width="60">NO</th>
        <th align="center" width="80">USERID</th>
        <th align="center" width="300">USERPW</th>
        <th align="center" width="100">USERNAME</th>
        <th align="center" width="180">REGDATE</th>
    </tr>
    <c:forEach items="${lsit}" var="member">
        <tr>
            <td align="center">${member.userNo}</td>
            <td align="center">
                <a href='/user/read?userNo=${member.userNo}'>${member.userId}</a></td>
            <td align="left">${member.userPw}</td>
            <td align="right">${member.userName}</td>
            <td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${member.regDate}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>