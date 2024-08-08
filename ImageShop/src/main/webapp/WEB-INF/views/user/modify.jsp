<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h2><spring:message code="user.header.modify"/></h2>
<form:form modelAttribute="member" action="modify">
    <form:hidden path="userNo"/>
    <table>
        <tr>
            <td><spring:message code="user.userId"/></td>
            <td><form:input path="userId" readonly="true"/></td>
            <td><font color="red"><form:errors path="userId"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="user.userName"/></td>
            <td><form:input path="userName"/></td>
            <td><font color="red"><form:errors path="userName"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="user.job"/></td>
            <td><form:select path="job" items="${jobList}" itemValue="value" itemLabel="label"/></td>
            <td><font color="red"><form:errors path="job"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="user.auth"/> - 1</td>
            <td>
                <form:select path="authList[0].auth" disabled="false">
                    <form:option value="" label="=== 선택해 주세요==="/>
                    <form:option value="ROLE_USER" label="사용자"/>
                    <form:option value="ROLE_MEMBER" label="회원"/>
                    <form:option value="ROLE_ADMIN" label="관리자"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><spring:message code="user.auth"/> - 2</td>
            <td><form:select path="authList[1].auth" disabled="false">
                <form:option value="" label="=== 선택해 주세요==="/>
                <form:option value="ROLE_USER" label="사용자"/>
                <form:option value="ROLE_MEMBER" label="회원"/>
                <form:option value="ROLE_ADMIN" label="관리자"/>
            </form:select></td>
        </tr>
        <tr>
            <td><spring:message code="user.auth"/> - 3</td>
            <td>
                <form:select path="authList[2].auth" disabled="false">
                    <form:option value="" label="=== 선택해 주세요==="/>
                    <form:option value="ROLE_USER" label="사용자"/>
                    <form:option value="ROLE_MEMBER" label="회원"/>
                    <form:option value="ROLE_ADMIN" label="관리자"/>
                </form:select>
            </td>
        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnModify"><spring:message code="action.modify" /></button>
    <button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>
<script>

    $(document).ready(function () {
        var formObj = $("#member");
        $("#btnModify").on("click", function () {
            formObj.submit();
        });
        $("#btnList").on("click", function () {
            self.location = "list";
        });
    });
</script>