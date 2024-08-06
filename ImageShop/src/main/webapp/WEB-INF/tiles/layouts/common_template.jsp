<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Tiles Layout</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
<titles:insertAttribute name="header" />
<div align="center">
    <titles:insertAttribute name="content" />
</div>

</body>
</html>
