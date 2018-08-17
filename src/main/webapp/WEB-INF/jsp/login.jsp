<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.06.2018
  Time: 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title">Login with Username and Password</h3>
                </div>
                <div class="panel-body">

                    <c:if test="${param.logout ne null}">
                        <div class="alert alert-info">You've been logged out successfully.</div>
                    </c:if>

                    <c:if test="${param.error ne null}">
                        <div class="alert alert-danger">Invalid Username or Password!</div>
                    </c:if>

                    <form method="post">
                        <%--<input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">--%>
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" placeholder="Username"
                                   name="username" value="admin">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="Password"
                                   name="password" value="admin">
                        </div>
                        <button type="submit" class="btn btn-default">Log in</button>
                        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
                    </form>
                </div>
            </div>
            <div style="font-size: smaller">
                <p>Login / Pass</p>
                <p><b>admin / admin</b> - create, save, view, edit, delete users</p>
                <p><b>user / user</b> - create, save, view users</p>
            </div>
        </div>
    </div>
</div>

</body>
</html>
