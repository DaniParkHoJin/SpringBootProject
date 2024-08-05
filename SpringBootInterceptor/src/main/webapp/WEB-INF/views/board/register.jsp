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
    <title>인터셉터 활용 - 접근 로그 저장</title>
</head>
<body>
<h3>게시글 등록</h3>
<form:form modelAttribute="board" action="register">
    <table>
        <tr>
            <td>Title</td>
            <td><form:input path="title"/></td>
            <td><font color="red"><form:errors path="title"/></font></td>
        </tr>
        <tr>
            <td>Writer</td>
            <td><form:input path="writer"/></td>
            <td><font color="red"><form:errors path="writer"/></font></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><form:textarea path="content"/></td>
            <td><font color="red"><form:errors path="content"/></font></td>
        </tr>
    </table>
    <div>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </div>
    <a href="list">List</a>
</form:form>
</body>
</html>