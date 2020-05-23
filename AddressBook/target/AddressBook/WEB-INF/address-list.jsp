<%@ page import="com.web.app.AddressBook" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.html" %>
<br>
<p>Sort by:
<a href="/addresses/list?sort=asc">ascending</a>
<a href="/addresses/list?sort=desc">descending</a>
</p>
<br>
<table border="1">
    <tr>
        <th>No</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Address</th>
        <th colspan="3">Operation</th>
    </tr>
    <%int num = 1;%>
    <%for (Object object : (AddressBook) request.getAttribute("addresses")) {%>

    <%String data = object.toString().replaceAll("First name: |Last name: |Address: ", ""); %>
    <%String firstName = data.substring(0, data.indexOf(','));%>
    <%String lastName = data.substring(data.indexOf(',') + 2, data.lastIndexOf(','));%>
    <%String address = data.substring(data.lastIndexOf(',') + 2);%>
    <tr>
        <td><%=num++%>
        </td>
        <td><%=firstName%>
        </td>
        <td><%=lastName%>
        </td>
        <td><%=address%>
        </td>
        <td>
            <a href="/addresses/read?first-name=<%=firstName%>&last-name=<%=lastName%>">READ</a>
        </td>
        <td>
            <a href="/addresses/update?first-name=<%=firstName%>&last-name=<%=lastName%>">UPDATE</a>
        </td>
        <td>
            <a href="/addresses/delete?first-name=<%=firstName%>&last-name=<%=lastName%>">DELETE</a>
        </td>

    </tr>
    <% }
    %>
</table>
</body>
</html>
