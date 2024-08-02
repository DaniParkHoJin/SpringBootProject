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
    <title>비동기 다중 파일 업로드</title>
</head>
<body>
<h2>상품 목록</h2>
<a href="register">상품 등록</a>
<table border="1">
    <tr class="header">
        <th align="center" width="80">상품</th>
        <th align="center" width="320">상품명</th>
        <th align="center" width="100">가격</th>
        <th align="center" width="80">편집</th>
        <th align="center" width="80">제거</th>
    </tr>
    <c:forEach items="${item3List}" var="item3">
        <tr class="record">
            <td align="center">${item3.itemId}</td>
            <td align="left">${item3.itemName}</td>
            <td align="right">${item3.price} 원</td>
            <td align="center"><a href="/item3/modify?itemId=${item3.itemId}">상품 편집</a></td>
            <td align="center"><a href="/item3/remove?itemId=${item3.itemId}">상품 제거</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>