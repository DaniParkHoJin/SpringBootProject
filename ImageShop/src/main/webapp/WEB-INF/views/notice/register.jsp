<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2><spring:message code="notice.header.register"/></h2>
<form:form modelAttribute="notice" action="register">
    <table>
        <tr>
            <td><spring:message code="notice.title"/></td>
            <td><form:input path="title"/></td>
            <td><font color="red"><form:errors path="title"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="board.content"/></td>
            <td><form:textarea path="content"/></td>
            <td><font color="red"><form:errors path="content"/></font></td>
        </tr>
    </table>
</form:form>
<div>
    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
        <button type="submit" id="btnRegister"><spring:message code="action.register"/></button>
    </sec:authorize>
    <button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>
<script>
    $(document).ready(function () {
        var formObj = $("#notice");
        $("#btnRegister").on("click", function () {
            formObj.submit();
        });
        $("#btnList").on("click", function () {
            self.location = "list";
        });
    });
</script>