<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h2><spring:message code="user.header.register"/></h2>
<form:form modelAttribute="member" action="setup">
    <table>
        <tr>
            <td><spring:message code="user.userId"/></td>
            <td><form:input path="userId"/></td>
            <td><font color="red"><form:errors path="userId"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="user.userPw"/></td>
            <td><form:input path="userPw"/></td>
            <td><font color="red"><form:errors path="userPw"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="user.userName"/></td>
            <td><form:input path="userName"/></td>
            <td><font color="red"><form:errors path="userName"/></font></td>
        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnRegister"><spring:message code="action.register"/></button>
    <button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>
<script>
    $(document).ready(function () {
        var formObj = $("#member");
        $("#btnRegister").on("click", function () {
            formObj.submit();
        });
        $("#btnList").on("click", function () {
            self.location = "list";
        });
    });

</script>