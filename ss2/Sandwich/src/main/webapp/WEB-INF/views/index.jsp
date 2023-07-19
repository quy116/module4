<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gaugaune
  Date: 19/07/2023
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>them gia vi ne</h1>
<form method="post">
    <table>
        <c:forEach items="${list}" var="c">
            <tr>
                <label >${c.getName()} </label>
                <input type="checkbox" name="checkbox" value="${c.name}">
            </tr>
        </c:forEach>
        <p>${arr}</p>
        <input type="submit">
    </table>

</form>
</body>
</html>
