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
    <title>트랜잭션</title>
</head>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        var formObj = $("#member");
        console.log(formObj);
        $("#btnModify").on("click", function () {
            formObj.attr("action", "/user/modify");
            formObj.attr("method", "get");
            formObj.submit();
        });
        $("#btnRemove").on("click", function () {
            formObj.attr("action", "/user/remove");
            formObj.submit();
        });
        $("#btnList").on("click", function () {
            self.location = "/user/list";
        });
    });

</script>
<body>
<h3>회원 정보</h3>
<form:form modelAttribute="member">
    <form:hidden path="userNo"/>
    <table>
        <tr>
        </tr>
        <tr>
        </tr>
        <tr>
            <td>userid</td>
            <td><form:input path="userId" readonly="true"/></td>
            <td>username</td>
            <td><form:input path="userName" readonly="true"/></td>
            <td>auth</td>
            <td>
                <form:select path="auth" disabled="true">
                    <form:option value="" label="=== 선택해주세요 ==="/>

                    <form:option value="ROLE_USER" label="사용자"/>
                    <form:option value="ROLE_MEMBER" label="회원"/>
                    <form:option value="ROLE_ADMIN" label="관리자"/>
                </form:select>
            </td>
        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnModify">Modify</button>
    <button type="submit" id="btnRemove">Remove</button>
    <button type="submit" id="btnList">List</button>
</div>
</body>
</html>