<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2018
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New/Edit Contact</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h1>Add New User</h1>
    <form method="post" action="/save" name="user">
        <div class="table-responsive">
            <table class="table table-bordered">
                <tr>
                    <td>Name :</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>Phone :</td>
                    <td><input type="text" name="phone" /></td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
                </tr>
            </table>
        </div>
    </form>
</div>
</body>
</html>
