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
    <title>AudioBook system | Add Language</title>
    <%@include file="../includers/js_links.jsp"%>
</head>
<body>
<%@include file="../includers/navbar.jsp"%>
<br>
    <div class="container">
        <div class="row at-5">
            <div class="col-sm-12">
                <form class="/addUser" method="post">
                    <div class="mb-3">
                        <h3>New Language</h3>
                        <div class="form-group">
                            <label class="form-label">Language</label>
                            <input type="text" name="language" class="form-control" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="form-group">
                        <button  type="submit" class="btn btn-primary">Add Language</button>
                    </div>
                </form>
                <div class="form-group">
                    <a href="/indexLan" class="btn btn-primary">All Languages</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
