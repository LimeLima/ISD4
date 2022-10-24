<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lime.DB.*" %><%--
  Created by IntelliJ IDEA.
  User: limko
  Date: 08.04.2021
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>AudioBook system | AudioBooks</title>
        <%@include file="../includers/js_links.jsp"%>
    </head>
    <body>
    <%@include file="../includers/navbar.jsp"%>
    <br>
        <div class="container">
            <div class="row at-5">
                <div class="col-sm-12">
                    <h3>Data of Audio Books from DataBase</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Title</th>
                                <th scope="col">Author</th>
                                <th scope="col">Year</th>
                                <th scope="col">Languages</th>
                                <th scope="col">Voices</th>
                                <th scope="col">Update</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<AudioBook> books = (ArrayList<AudioBook>) request.getAttribute("knigi");

                                if (books != null) {
                                    for (AudioBook book : books) {
                            %>
                            <tr>
                                <td><%=book.getId()%></td>
                                <td><%=book.getTitle()%></td>
                                <td><%=book.getAuthor()%></td>
                                <td><%=book.getBook_year()%></td>
                                <td><%=DBManager.getLanguage(book.getLanguage_id()).getLan()%></td>
                                <td><%=DBManager.getVoice(book.getVoice_id()).getVoice()%></td>
                                <td><a href="${pageContext.request.contextPath}/updateBook?id=<%=book.getId()%>" class="btn btn-primary">Update</a></td>
                                <td><a href="${pageContext.request.contextPath}/deleteBook?id=<%=book.getId()%>" class="btn btn-primary">Delete</a></td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                    <a href="/addBook" class="btn btn-primary">Add new Audio Book</a>
                </div>
            </div>
        </div>
    </body>
</html>
