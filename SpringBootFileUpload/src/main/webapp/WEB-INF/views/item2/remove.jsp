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
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(() => {
        var formObj = $("#item2");
        $("#btnRemove").on("click", () => {
            formObj.attr("action", "/item2/remove");
            formObj.attr("method", "post");
            formObj.submit();
        });
        $("#btnList").on("click", () => {
            self.location = "/item2/list";
        });
    });
</script>
<body>
<h2>상품 삭제</h2>
<form:form modelAttribute="item2" action="remove">
    <form:hidden path="itemId"/>
    <table>
        <tr>
            <td>상품명</td>
            <td><form:input path="itemName" disabled="true"/></td>

        </tr>
        <tr>
            <td>가격</td>
            <td><form:input path="price" disabled="true"/>&nbsp;원</td>
        </tr>
        <tr>
            <td>파일</td>
            <td><img src="display?itemId=${item2.itemId}" width="210" height="240"></td>
        </tr>
        <tr>
            <td>파일</td>
            <td><img src="display2?itemId=${item2.itemId}" width="210" height="240"></td>
        </tr>
        <tr>
            <td>개요</td>
            <td><form:textarea path="description" disabled="true"/></td>
        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnRemove">Remove</button>
    <button type="submit" id="btnList">List</button>
</div>
</body>
</html>