<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Userd</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h1>User's List</h1>

    <table border="1" class="table table-striped table-bordered table-condensed" style="width:600px">
        <td>ID</td>
        <td>Name</td>
        <td>Phone</td>
        <td>Email</td>
        <security:authorize access="hasRole('ADMIN')">
            <td>Action</td>
        </security:authorize>
        <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>

            <security:authorize access="hasRole('ADMIN')">
                <td>
                    <a href="edit/${user.id}" class="btn btn-primary">Edit</a>
                    <a href="delete/${user.id}" class="btn btn-danger">Delete</a>
                </td>
            </security:authorize>


            </c:forEach>
        </tr>
    </table>
    <p>
        <a href="register" class="btn btn-primary">Add New User</a>
    </p>
    <p><a href="<c:url value="/logout" />" class="btn btn-primary">Logout</a></p>
</div>
</body>
</html>