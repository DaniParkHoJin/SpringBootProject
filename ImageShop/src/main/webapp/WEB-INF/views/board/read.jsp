<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h2><spring:message code="board.header.read"/></h2>
<form:form modelAttribute="board">
    <form:hidden path="boardNo"/>
    <table>
        <tr>
            <td><spring:message code="board.title"/></td>
            <td><form:input path="title" readonly="true"/></td>
            <td><font color="red"><form:errors path="title"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="board.writer"/></td>
            <td><form:input path="writer" readonly="true"/></td>
            <td><font color="red"><form:errors path="writer"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="board.content"/></td>
            <td><form:textarea path="content" readonly="true"/></td>
            <td><font color="red"><form:errors path="content"/></font></td>
        </tr>
    </table>
</form:form>
<div>
    <sec:authentication property="principal" var="pinfo"/>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <button type="submit" id="btnEdit"><spring:message code="action.edit"/></button>
        <button type="submit" id="btnRemove"><spring:message code="action.remove"/></button>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_MEMBER')">
        <c:if test="${pinfo.username eq board.writer}">
            <button type="submit" id="btnEdit"><spring:message code="action.edit"/></button>
            <button type="submit" id="btnRemove"><spring:message code="action.remove"/></button>
        </c:if>
    </sec:authorize>
    <button type="submit" id="btnList"><spring:message code="action.list"/></button>
</div>
<script>
    $(document).ready(function () {
        let formObj = $("#board");

        let pageObj = $("#page");
        let sizePerPageObj = $("#sizePerPage");
        let pageVal = pageObj.val();
        let sizePerPageVal = sizePerPageObj.val();

        $("#btnEdit").on("click",function () {
            let boardNo = $("#boardNo");
            let boardNoVal = boardNo.val();
            self.location = "/board/modify?boardNo=" + boardNoVal;
        });
        $("#btnRemove").on("click",function () {
           formObj.attr("action", "/board/remove");
           formObj.submit();
        });
        $("#btnList").on("click",function () {
           self.location = "/board/list";
        });
    });

</script>
