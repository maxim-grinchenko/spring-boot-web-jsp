<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.06.2018
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New/Edit Contact</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value="css/main.css" />" rel="stylesheet">

</head>
<body>
<div id="wrapp">
    <h1>Add New User</h1>
    <form method="post" action="/save" name="user">
        <div class="table-responsive">
            <table class="table table-bordered">
                <tr>
                    <td style="width: 159px">Name :</td>
                    <td style="width: 450px"><input class="form-control" type="text" name="name" placeholder="your name" minlength="2" maxlength="18" required/></td>
                    <span class="form__error">This field must contain name min = 2, max = 18 length</span>
                </tr>
                <tr>
                    <td style="width: 159px">Phone :</td>
                    <td style="width: 450px"><input class="form-control" type="tel" name="phone" placeholder="+123456789"
                               pattern="^\s*(?:\+?(\d{1,3}))?([-. (]*(\d{3})[-. )]*)?((\d{3})[-. ]*(\d{2,4})(?:[-.x ]*(\d+))?)\s*$"
                               minlength="6" maxlength="18" required/>
                        <span class="form__error">This field must contain phone in the format +XX(XXX)XXX-XX-XX or XXXXXXXXXXXX</span>
                    </td>
                </tr>
                <tr>
                    <td style="width: 159px">Email :</td>
                    <td style="width: 450px"><input type="email" name="email" class="form-control" placeholder="your_email@example.com"
                                                    pattern="([\w\.\-_]+)?\w+@[\w-_]+(\.\w+){1,}" required/></td>
                    <span class="form__error">This field must contain e-mail in the format example@site.com</span>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" class="btn btn-primary btn-sm"  value="Submit" /></td>
                </tr>
            </table>
        </div>
    </form>
</div>
</body>
</html>
