<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gaugaune
  Date: 20/07/2023
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${email.signature}</h1>
<table>
    <tr>
        <th>languages</th>
        <th>size</th>
        <th>spamsFilter</th>
        <th>signature</th>
        <th>sua~</th>
    </tr>
    <form:form modelAttribute="email" id="quy" action="showForm" method="get">
        <tr>
            <td>
                    <form:input path="languages"/>
            </td>
            <td>
                <form:input path="size"/>
            </td>
            <td>
                <form:input path="spamsFilter"/>
            </td>
            <td>
                <form:input path="signature"/>
            </td>

    </form:form>
</table>
<button type="button" onclick="submitForm()">submit ne</button>
</body>
<script>
    function submitForm() {
        document.getElementById("quy").submit();

    }
</script>
</html>
