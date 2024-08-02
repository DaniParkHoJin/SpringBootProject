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
    $(document).ready(() => {
        let formObj = $("#item3");

        $("#btnModify").on("click", function () {
            formObj.attr("action", "/item/modify");
            formObj.attr("method", "post");
            formObj.submit();
        });
        $("#btnList").on("click", function () {
            self.location = "/item3/list";
        });
        $(".uploadedList").on("click", "span", function (event) {
            $(this).parent("div").remove();
        });

        function getOriginalName (fileName) {
            if (checkImageType(fileName)) {
                return;
            }
            let idx = fileName.indexOf("_") + 1;
            return fileName.substr(dix);
        }
        function getThumbnailName (fileName){
            let front = fileName.substr(0, 12);
            let end = fileName.substr(12);

            console.log("front : " + front);
            console.log("end : " + end);
            return front + "s_" + end;
        }
        function checkImageType(fileName)
        {
            let pattern = /jpg|gid|png|jpeg/i;

            return fileName.match(pattern);
        }
        let itemId = ${item3.itemId};
        console.log("itemId : " + itemId);

        $.getJSON("/item3/getAttach/" + itemId, function (list){
            $(list).each(function () {

                console.log("data : " + this);

                let data = this;

                let str = "";
                if (checkImageType(data)) {
                    str = "<div><a href='/item3/displayFile?fileName=" + data + "'>" + "<img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>" + "</a><span>X</span></div>";
                } else {
                    str = "<div><a href='/item3/displayFile?fileName=" + data + "'>" + getOriginalName(data) + "</a><span>X</span></div>";
                }
                $(".uploadedList").append(str);
            });
        });

        $("#item3").submit(function (event){
            event.preventDefault();
            let that = $(this);
            let str = "";
            $(".uploadedList a").each(function (index){
                let value = $(this).attr("href");
                value = value.substr(28);
                str += "<input type='hidden' name='files[" + index + "]' value='" + value + "'> ";
            });
            console.log("str = " + str);
            that.append(str);
            that.get(0).submit();
        });
        $("#inputFile").on("change", function (event){
            console.log("change");
            let files = event.target.files;
            let file = files[0];
            console.log(file);
            let formData = new FormData();
            formData.append("file", file);
            $.ajax({
                url: '/item3/uploadAjax',
                data: formData,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (data){
                    console.log(data);
                    var str = "";
                    if (checkImageType(data)) {
                        str = "<div><a href='/item3/displayFile?fileName=" + data + "'>"
                            + "<img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>" + "</a><span>X</span></div>";
                    } else {
                        str = "<div><a href='/item3/displayFile?fileName=" + data + "'>" + getOriginalName(data) + "</a>" + "<span>X</span></div></div>";
                    }
                    $(".uploadedList").append(str);
                }
            });
        });
    });


</script>
<body>
<h2>상품 수정</h2>
<form:form modelAttribute="item3" action="modify" enctype="multipart/form-
data">
    <form:hidden path="itemId"/>
    <table>
        <tr>
            <td>상품명</td>
            <td><form:input path="itemName"/></td>
            <td><font color="red"><form:errors path="itemName"/></font></td>
        </tr>
        <tr>
            <td>가격</td>
            <td><form:input path="price"/>&nbsp;원
            </td>
            <td><font color="red"><form:errors path="price"/></font></td>
        </tr>
        <tr>
            <td>파일</td>
            <td>
                <input type="file" id="inputFile">
                <div class="uploadedList"></div>
            </td>
            <td></td>
        </tr>
        <tr>
            <td>개요</td>
            <td><form:textarea path="description"/>
            </td>
            <td><font color="red"><form:errors path="description"/></font></td>

        </tr>
    </table>
</form:form>
<div>
    <button type="submit" id="btnModify">Modify</button>
    <button type="submit" id="btnList">List</button>
</div>
</body>
</html>