<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Oljas
  Date: 02.07.2020
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FooBar</title>
</head>
<body>
<h2>Please enter the number:</h2></body><br>
<hr>
<form:form modelAttribute="FooBar" method="post" action="/showResults">
    <label>Pass Integer Number</label>
    <form:input path="integer" />
    <label></label>
    <input type="submit" value="Submit"/>

</form:form>
</body>
</html>
