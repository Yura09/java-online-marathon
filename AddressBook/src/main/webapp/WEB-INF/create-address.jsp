<%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 22.05.2020
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Address</title>
</head>
<body>
<%@include file="header.html" %>
<br>

<form action="/addresses/create" method="post">
    <table>
        <%
            String message = (String) request.getSession().getAttribute("errorMessage");
            if (message != null) {
        %>
        <div style="color: #3c54ff;"><%=message%>
        </div>
        <%}%>
        <tr>
            <td>
                <label for="firstName">First name: </label>
            </td>
            <td>
                <input type="text" id="firstName" name="firstName">
            </td>
        </tr>
        <tr>
            <td><label for="lastName">Last name: </label></td>
            <td><input type="text" id="lastName" name="lastName"></td>
        </tr>
        <tr>
            <td><label for="address">Address: </label></td>
            <td><input type="text" id="address" name="address"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="create">
            </td>
            <td>
                <input type="reset" value="clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
