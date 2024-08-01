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
        var formObj = $("#item");
        $("#btnModify").on("click", () => {
            formObj.attr("action", "/item/modify");
            formObj.attr("method", "post");
            formObj.submit();
        });
        $("#btnList").on("click", () => {
            self.location = "/item/list";
        });
    });
</script>
<body>
<h2>상품 수정</h2>
<form:form modelAttribute="item" action="modify" enctype="multipart/form-data">
    <form:hidden path="itemId"/>
    <form:hidden path="pictureUrl"/>
    <table>
        <tr>
            <td>상품명</td>
            <td><form:input path="itemName"/></td>
            <td><font color="red"><form:errors path="itemName"/></font></td>
        </tr>
        <tr>
            <td>가격</td>
            <td><form:input path="price"/>&nbsp;원
            </td>
            <td><font color="red"><form:errors path="price"/></font></td>
        </tr>
        <tr>
            <td>파일</td>
            <td><img src="display?itemId=${item.itemId}" width="210" height="240">
        </tr>
        <tr>
            <td>파일</td>
            <td><input type="file" name="picture"/></td>
            <td></td>
        </tr>
        <tr>
            <td>개요</td>
            <td><form:textarea path="description"/></td>
            <td><font color="red"><form:errors path="description"/></font></td>
        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnModify">Modify</button>
    <button type="submit" id="btnList">List</button>
</div>
</body>
</html>