<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gaugaune
  Date: 18/07/2023
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/changeMoney">
    <label>nhap do vao</label>
    <input type="number" name="dola">
    <input type="number" name="VND" value="23000" placeholder="23000" readonly>
    <input type="submit">
    <p>${result}</p>
</form>
</body>
</html>
