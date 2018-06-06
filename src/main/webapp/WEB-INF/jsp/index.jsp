<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2018
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

<div class="text-center">
    <p>
    <h1>Welcome to application!</h1></p>
    <p><a href="register" class="btn btn-primary">Add New User</a></p>
    <p><a href="view" class="btn btn-primary">List Users</a></p>
    <p><a href="<c:url value="/logout" />" class="btn btn-primary">Logout</a></p>
</div>
</body>
</html>
