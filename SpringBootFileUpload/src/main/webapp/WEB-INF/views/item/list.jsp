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
    <title>파일 업로드</title>
</head>
<body>
<h2>상품 목록</h2>
<a href="register">상품 등록</a>
<table border="1">
    <tr>
        <th align="center" width="80">상품ID</th>
        <th align="center" width="320">상품명</th>
        <th align="center" width="100">가격</th>
        <th align="center" width="80">편집</th>
        <th align="center" width="80">제거</th>
    </tr>
    <c:forEach items="${itemList}" var="item">
        <tr>
            <td align="center">${item.itemId}</td>
            <td align="left">${item.itemName}</td>
            <td align="right">${item.price} 원</td>
            <td align="center"><a
                    href="modify?itemId=${item.itemId}">상품 편집</a></td>
            <td align="center"><a
                    href="remove?itemId=${item.itemId}">상품 제거</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>