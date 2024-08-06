<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>스프링 시큐리티</title>
</head>
<body>
<<h1>환영합니다!</h1>
<P>서버의 시간은 ${serverTime} 입니다.</P>
<a href="board/list">회원 게시판</a>
<br>
<a href="notice/list">공지사항</a>
<br>
<!-- 로그인을 하지 않은 경우 -->
<sec:authorize access="isAnonymous()"> 
<a href="/login">로그인</a>
</sec:authorize>
<!-- 인증된 사용자인 경우 true -->
<sec:authorize access="isAuthenticated()"> 
<a href="/logout">로그아웃</a>
</sec:authorize>
</body>
</html>