<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/table-style.css" type="text/css" media="screen"/>
    <title>Home Page</title>
    <title>Users</title>
</head>
<body>
<h1><%= "Users Table" %>
</h1>
<br/>
<div>
    <table>
        <thead>
        <tr>
            <th> Id</th>
            <th> Name</th>
            <th> Email</th>
            <th> Gender</th>
            <th> Status</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${usersDetails}" var="pp">
            <tr>
                <td><c:out value="${pp.id}"/></td>
                <td><c:out value="${pp.name}"/></td>
                <td><c:out value="${pp.email}"/></td>
                <td><c:out value="${pp.gender}"/></td>
                <td><c:out value="${pp.status}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
