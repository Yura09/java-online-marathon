<%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 22.05.2020
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info about Address</title>
</head>
<body>
<%@include file="header.html"%>
<br>
<p>First Name: <%=request.getAttribute("first-name")%></p>
<p>Last Name: <%=request.getAttribute("last-name")%></p>
<p>Address: <%=request.getAttribute("address")%></p>
</body>
</html>
