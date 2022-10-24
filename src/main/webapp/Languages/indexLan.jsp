<%@ page import="com.lime.DB.DBManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lime.DB.User" %>
<%@ page import="com.lime.DB.Language" %><%--
  Created by IntelliJ IDEA.
  User: limko
  Date: 08.04.2021
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>AudioBook system | Languages</title>
        <%@include file="../includers/js_links.jsp"%>
    </head>
    <body>
    <%@include file="../includers/navbar.jsp"%>
    <br>
        <div class="container">
            <div class="row at-5">
                <div class="col-sm-12">
                    <h3>Data of Languages from DataBase</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Language</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("yazyki");

                                if (languages != null) {
                                    for (Language lan : languages) {
                            %>
                            <tr>
                                <td><%=lan.getId()%></td>
                                <td><%=lan.getLan()%></td>
                                <td><a href="${pageContext.request.contextPath}/deleteLan?id=<%=lan.getId()%>" class="btn btn-primary">Delete</a></td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                    <a href="/addLan" class="btn btn-primary">Add Language</a>
                </div>
            </div>
        </div>
    </body>
</html>
