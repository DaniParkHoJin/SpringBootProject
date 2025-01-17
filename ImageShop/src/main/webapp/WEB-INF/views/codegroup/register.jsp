<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2><spring:message code="codegroup.header.register"/></h2>
<form:form modelAttribute="codeGroup" action="register">
<table>
    <tr>
        <td><spring:message code="codegroup.groupCode"/></td>
        <td><form:input path="groupCode"/></td>
        <td><font color="red"><form:errors path="groupCode"/></font></td>
    </tr>
    <tr>
        <td><spring:message code="codegroup.groupName" /></td>
        <td><form:input path="groupName" /></td>
        <td><font color="red"><form:errors path="groupName"/></font></td>
    </tr>
</table>
</form:form>
<div>
    <button type="submit" id="btnRegister"><spring:message code="action.register" /></button>
    <button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>

<script>
    $(document).ready(function() {
        var formObj = $("#codeGroup");
        $("#btnRegister").on("click", function() {
            formObj.submit();
        });
        $("#btnList").on("click", function() {
            self.location = "list";
        });
    });
</script>