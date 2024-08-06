<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Image Shop</title>
</head>
<body>
<%--<p>${serverTime}</p>--%>
<%--요구사항 정의 : 메시지를 프로퍼티 파일로 관리해야 한다.--%>
<%--메시지프로퍼티 위치 src/main/resources --%>
<h1><spring:message code="common.homeWelcome" /></h1>
<p>${serverTime}</p>
</body>
</html>