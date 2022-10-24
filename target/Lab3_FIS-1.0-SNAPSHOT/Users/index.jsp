<%@ page import="com.lime.DB.DBManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lime.DB.User" %><%--
  Created by IntelliJ IDEA.
  User: limko
  Date: 08.04.2021
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>AudioBook system | Users</title>
        <%@include file="../includers/js_links.jsp"%>
    </head>
    <body>
    <%@include file="../includers/navbar.jsp"%>
    <br>
        <div class="container">
            <div class="row at-5">
                <div class="col-sm-12">
                    <h3>Data of User from DataBase</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Full Name</th>
                                <th scope="col">E-mail</th>
                                <th scope="col">Password</th>
                                <th scope="col">Phone Number</th>
                                <th scope="col">Update</th>
                                <th scope="col">Delete</th>
                            </tr>

                        </thead>
                        <tbody>
                            <%
                                ArrayList<User> users = (ArrayList<User>) request.getAttribute("polzovateli");

                                if (users != null) {
                                    for (User user : users) {
                            %>
                            <tr>
                                <td><%=user.getId()%></td>
                                <td><%=user.getFullName()%></td>
                                <td><%=user.getEmail()%></td>
                                <td><%=user.getPassword()%></td>
                                <td><%=user.getPhone()%></td>
                                <td><a href="${pageContext.request.contextPath}/update?id=<%=user.getId()%>" class="btn btn-primary">Update</a></td>
                                <td><a href="${pageContext.request.contextPath}/deleteUser?id=<%=user.getId()%>" class="btn btn-primary">Delete</a></td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                    <a href="/addUser" class="btn btn-primary">Add User</a>
                </div>
            </div>
        </div>
    </body>
</html>
