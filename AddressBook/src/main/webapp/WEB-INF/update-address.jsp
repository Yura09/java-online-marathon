<%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 22.05.2020
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Address</title>
</head>
<body>
<%@include file="header.html" %>
<br>
<form action="/addresses/update" method="post">

    <table>
        <tr>
            <td>
                <label for="firstName">First name: </label>
            </td>
            <td>
                <input type="text" id="firstName" name="firstName"
                       value="<%=(String)request.getAttribute("first-name")%>" disabled>
            </td>
        </tr>
        <tr>
            <td><label for="lastName">Last name: </label></td>
            <td><input type="text" id="lastName" name="lastName" value="<%=(String)request.getAttribute("last-name")%>"
                       disabled></td>
        </tr>
        <tr>
            <td><label for="address">Address: </label></td>
            <td><input type="text" id="address" name="address" value="<%=(String)request.getAttribute("address")%>">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="update">
            </td>
            <td>
                <input type="reset" value="clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
