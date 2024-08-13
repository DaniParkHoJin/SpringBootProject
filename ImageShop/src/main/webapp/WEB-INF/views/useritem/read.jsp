<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<h2><spring:message code="useritem.header.read"/></h2>
<form:form modelAttribute="userItem">
    <form:hidden path="userItemNo" />
    <table>
        <tr>
            <td><spring:message code="useritem.itemName"/></td>
            <td><form:input path="itemName" readonly="true"/></td>
            <td><font color="red"><form:errors path="itemName"/></font></td>
        </tr>
        <tr>
            <td><spring:message code="useritem.itemPrice"/></td>
            <td><form:input path="price" readonly="true"/>&nbsp;원</td>
            <td><font color="red"><form:errors path="price"/></font></td>
        </tr>

        <tr>
            <td><spring:message code="useritem.itemFile"/></td>
            <td><img src="/item/display?itemId=${userItem.itemId}" width="210"></td>
        </tr>
        <tr>
            <td><spring:message code="useritem.itemDescription"/></td>
            <td><form:textarea path="description" readonly="true"/>&nbsp;원</td>
            <td><font color="red"><form:errors path="description"/></font></td>
        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnList"><spring:message code="action.list"/></button>

</div>
<script>
    $(document).ready(function () {
        var formObj = $("#useritem");

        $("#btnList").on("click", function () {
            self.location = "list";
        });
    });

</script>
