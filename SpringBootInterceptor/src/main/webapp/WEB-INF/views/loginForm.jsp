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
    <title>인터셉터 로그인</title>
</head>
<body>
<h1>로그인</h1>
<form method="post" action="/login">
    <div>
        <input type="text" name="userId" value="admin">
    </div>
    <div>
        <input type="password" name="userPw" value="1234">
        <input type="submit">
    </div>
    <div>
    </div>
</form>
</body>
</html>