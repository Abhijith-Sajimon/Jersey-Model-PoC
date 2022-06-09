<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/table-style.css" type="text/css" media="screen"/>
    <title>Posts</title>
</head>
<body>
<h1><%= "Posts Table" %>
</h1>
<br/>
<div>
    <table>
        <thead>
        <tr>
            <th> Id</th>
            <th> UserId</th>
            <th> Title</th>
            <th> Body</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${postsDetails}" var="pp">
            <tr>
                <td><c:out value="${pp.id}"/></td>
                <td><c:out value="${pp.userId}"/></td>
                <td><c:out value="${pp.title}"/></td>
                <td><c:out value="${pp.body}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
