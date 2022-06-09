<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Posts</title>
</head>
<body>
<h1><%= "Comments Table" %>
</h1>
<br/>
<div>
    <table class="table Comments">
        <thead>
        <tr>
            <th> Id</th>
            <th> PostId</th>
            <th> Email</th>
            <th> Body</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${commentsDetails}" var="pp">
            <tr>
                <td><c:out value="${pp.id}"/></td>
                <td><c:out value="${pp.post_id}"/></td>
                <td><c:out value="${pp.email}"/></td>
                <td><c:out value="${pp.body}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
