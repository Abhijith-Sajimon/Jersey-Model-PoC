<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: skyblue;
            color: black;
        }
    </style>
</head>
<body>
<h1><%= "Welcome to my page" %>
</h1>
<br/>
<div class="topnav">
    <a class="Inactive">HOME</a>
    <a href="UsersServlet">USERS</a>
    <a href="PostsServlet">POSTS</a>
    <a href="CommentsServlet">COMMENTS</a>
</div>

<div style="padding-left:16px">
    <h2>Jersey Web Application</h2>
    <p>This is a model PoC to understand QGenda</p>
</div>
</body>
</html>
