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
    <title>인터셉터 활용 - 세션 처리</title>
</head>
<body>
<h1>
    환영합니다.
</h1>
<p>서버시간은 ${serverTime}</p>
${userInfo.userId} <br>
${userInfo.userName} <br>
<c:if test="${userInfo.userId eq 'admin'}">
    <a href="board/list">게시판</a>
</c:if>
<c:if test="${empty userInfo.userId}">
    <a href="login">로그인</a>
</c:if>
</body>
</html>