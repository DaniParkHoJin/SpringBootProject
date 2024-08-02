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
    <title>비동기 다중 파일 업로드</title>
</head>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready( () => {
        let formObj = $("#item3");
        $("#btnRemove").on("click", () => {
            formObj.attr("action", "/item3/remove");
            formObj.attr("method", "post");
            formObj.submit();
        });
        $("#btnList").on("click", ()=> {
            self.location = "/item3/list";
        });

        getOriginalName = (fileName) => {
            if (checkImageType(fileName)) {
                return;
            }
            let idx = fileName.indexOf("_") + 1;
            return fileName.substr(idx);
        }

        getThumbnailName = (fileName) => {
            let front = fileName.substr(0, 12);
            let end = fileName.substr(12);
            console.log("front : " + front);
            console.log("end : " + end);
            return front + "s_" + end;
        }

        checkImageType = (fileName) => {
            let pattern = /jpg|gif|png|jpeg/i;
            return fileName.match(pattern);
        }

        let itemId = ${item3.itemId};
        console.log("itemId : " + itemId);
        $.getJSON("/item3/getAttach/" + itemId, (list) => {
            $(list).each(()=> {
                console.log("data : " + this);
                let data = this;
                let str = "";
                if (checkImageType(data)) {
                    str = "<div><a href='/item3/displayFile?fileName=" + data + "'>" + "<img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>" + "</a></div>";
                } else {
                    str = "<div><a href='/item3/displayFile?fileName=" + data + "'>" + getOriginalName(data) + "</a></div>";
                }
                $(".uploadedList").append(str);
            });
        });

    });


</script>
<body>
<h2>상품 삭제</h2>
<form:form modelAttribute="item3" action="delete">
    <form:hidden path="itemId"/>
    <table>
        <tr>
            <td>상품명</td>
            <td><form:input path="itemName" disabled="true"/></td>
        </tr>
        <tr>
            <td>가격</td>
            <td><form:input path="price" disabled="true"/>&nbsp;원</td>
        </tr>
        <tr>

            <td>파일</td>
            <td>
                <div class="uploadedList"></div>
            </td>
        </tr>
        <tr>
            <td>개요</td>
            <td><form:textarea path="description" disabled="true"/></td>
        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnRemove">Remove</button>
    <button type="submit" id="btnList">List</button>
</div>
</body>
</html>