<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gaugaune
  Date: 20/07/2023
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="edit" modelAttribute="email">
    <h1>Setting</h1>
    <div>
        languages
        <form:select path="languages">
            <form:options items="${languages}"/>
        </form:select>
    </div>
    <div>
        Page Size
        <form:select path="size">
            <form:options items="${size}"/>
        </form:select>
        email per page
    </div>
    <div>
        Spams filter
        <form:checkbox path="spamsFilter"/>
        ENable spams filter
    </div>
    <div>signature <form:textarea path="signature"/></div>
    <form:button>update</form:button>

</form:form>


</body>
</html>
