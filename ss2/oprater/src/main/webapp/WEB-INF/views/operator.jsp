<%--
  Created by IntelliJ IDEA.
  User: gaugaune
  Date: 19/07/2023
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="operator">
  <input name="inputTop" value="0" type="number" placeholder="nhap so vao" >
  <input name="inputBottom" type="number" placeholder="nhap so vao" value="0" >

  <input type="submit" name="result" value="+">
  <input type="submit" name="result" value="-">
  <input type="submit" name="result" value="*">
  <input type="submit" name="result" value="/">
</form>
<p>${sum}</p>
</body>
</html>
