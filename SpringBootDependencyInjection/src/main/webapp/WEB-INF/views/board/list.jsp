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
    <title>list</title>
</head>
<body>
<a href="register">New</a>
<table border="1">
    <tr>
        <th align="center" width="80">NO</th>
        <th align="center" width="320">TITLE</th>
        <th align="center" width="100">WRITER</th>
        <th align="center" width="180">REGDATE</th>
    </tr>
    <c:choose>
        <c:when test="${empty list}">
            <tr>
                <td colspan="4">
                    List is empty.
                </td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach items="${list}" var="board">
                <tr>
                    <td align="center">${board.boardNo}</td>
                    <td align="left"><a
                            href="/board/read?boardNo=${board.boardNo}">${board.title}</a></td>
                    <td align="right">${board.writer}</td>
                    <td align="center"><javatime:format
                            value="${board.regDate}" pattern="yyyy-MM-dd HH:mm"/></td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>

</body>
</html>