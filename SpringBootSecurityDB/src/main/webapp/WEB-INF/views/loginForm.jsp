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
    <title>Login</title>
</head>
<body>
<h1>로그인</h1>
<a href="/">HOME</a>
<h2>
    <c:out value="${error}" />
</h2>
<h2>
    <c:out value="${logout}" />
</h2>
<form method="post" action="/login">
    <div>
        <input type="text" name="username" value="">
    </div>
    <div>
        <input type="password" name="password" value="">
    </div>
    <div>
        <input type="submit">
    </div>
    <sec:csrfInput />
</form>

</body>
</html>