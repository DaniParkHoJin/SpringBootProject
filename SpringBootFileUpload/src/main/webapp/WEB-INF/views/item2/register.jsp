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
    <title>다중 이미지 업로드</title>
</head>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(() => {
        let formObj = $("#item2");
        $("#btnRegister").on("click", () => {
            formObj.attr("action", "/item2/register");
            formObj.attr("method", "post");
            formObj.submit();
        });
        $("#btnList").on("click", () => {
            self.location = "item2/list";

        });

    });
</script>
<body>
<h2>상품 등록</h2>

<form:form modelAttribute="item2" action="register" enctype="multipart/form-data">
    <table>
        <tr>
            <td>
                상품명
            </td>
            <td>
                <form:input path="itemName"/>
            </td>
            <td>
                <font color="red"><form:errors path="itemName"/></font>
            </td>
        </tr>
        <tr>
            <td>가격</td>
            <td><form:input path="price"/>&nbsp;원
            </td>
            <td><font color="red"><form:errors path="price"/></font></td>
        </tr>
        <tr>
            <td>파일</td>
            <td><input type="file" name="picture"/></td>
            <td></td>
        </tr>
        <tr>
            <td>파일</td>
            <td><input type="file" name="picture"/></td>
            <td></td>
        </tr>
        <tr>
            <td>개요</td>
            <td><form:textarea path="description"/></td>
            <td><form:errors path="description"/></td>
        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnRegister">Register</button>
    <button type="submit" id="btnList">List</button>
</div>
</body>
</html>