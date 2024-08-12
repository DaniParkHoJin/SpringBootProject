<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h2><spring:message code="notice.header.read"/></h2>
<form:form modelAttribute="notice">
    <form:hidden path="noticeNo"/>

    <table>
        <tr>
            <td><spring:message code="notice.title"/></td>
            <td><form:input path="title" readonly="true"/></td>
            <td><font color="red"><form:errors path="title"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="notice.content"/></td>
            <td><form:textarea path="content" readonly="true"/></td>
            <td><font color="red"><form:errors path="content"/></font></td>
        </tr>
    </table>
</form:form>
<div>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <button type="submit" id="btnEdit"><spring:message code="action.edit"/></button>
        <button type="submit" id="btnRemove"><spring:message code="action.remove"/></button>
    </sec:authorize>
    <button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>
<script>
    $(document).ready(function () {
        let formObj = $("#notice");

        $("#btnEdit").on("click", function () {
            let noticeNO = $("#noticeNo");
            let noticeNoVal = noticeNO.val();
            self.location = "/notice/modify?noticeNo=" + noticeNoVal;
        });
        $("#btnRemove").on("click", function () {
            formObj.attr("action", "remove");
            formObj.submit();
        });
        $("#btnList").on("click", function () {
            self.location = "/board/list";
        });
    });

</script>
