<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2018
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Contact</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h1>Edit User</h1>

    <form:form method="post" action="/save" >
        <div class="table-responsive">
            <table class="table table-bordered">
                <tr>
                    <td>ID :</td>
                    <td><form:input type="text" path="id"  /></td>
                </tr>
                <tr>
                    <td>Name :</td>
                    <td><form:input type="text" path="name"  /></td>
                </tr>
                <tr>
                    <td>Phone :</td>
                    <td><form:input type="text" path="phone"/></td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><form:input type="text" path="email" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
                </tr>
            </table>
        </div>
    </form:form>

</div>
</body>
</html>
