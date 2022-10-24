<%@ page import="com.lime.DB.User" %><%--
  Created by IntelliJ IDEA.
  User: limko
  Date: 08.04.2021
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AudioBook system | Update User</title>
    <%@include file="../includers/js_links.jsp"%>
</head>
<body>
<%@include file="../includers/navbar.jsp"%>
    <br>
    <div class="container">
        <div class="row at-5">
            <div class="col-sm-12">
                <%
                    User user = (User) request.getAttribute("user");
                %>
                <form class="/update" method="post">
                    <div class="mb-3">
                        <h3>ID: <%=user.getId()%></h3>
                        <div class="form-group">
                            <label class="form-label">Full Name</label>
                            <input type="text" name="fullName" value="<%=user.getFullName()%>" class="form-control" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="mb-3">
                        <div class="form-group">
                            <label class="form-label">E-mail</label>
                            <input type="text" name="email" value="<%=user.getEmail()%>" class="form-control" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="mb-3">
                        <div class="form-group">
                            <label class="form-label">Password</label>
                            <input type="text" name="password" value="<%=user.getPassword()%>" class="form-control" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="mb-3">
                        <div class="form-group">
                            <label class="form-label">Phone number</label>
                            <input type="text" name="phone" value="<%=user.getPhone()%>" class="form-control" aria-describedby="emailHelp">
                        </div>
                    </div>
                        <div class="form-group">
                            <button  type="submit" class="btn btn-primary">Update User</button>
                        </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
