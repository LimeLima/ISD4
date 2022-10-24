<%@ page import="com.lime.DB.User" %>
<%@ page import="com.lime.DB.DBManager" %>
<%@ page import="com.lime.DB.Language" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lime.DB.Voice" %>
<%--
  Created by IntelliJ IDEA.
  User: limko
  Date: 08.04.2021
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AudioBook system | Add Audio Book</title>
    <%@include file="../includers/js_links.jsp"%>
</head>
<body>
<%@include file="../includers/navbar.jsp"%>
<br>
    <div class="container">
        <div class="row at-5">
            <div class="col-sm-12">
                <form class="/addBook" method="post">
                    <div class="mb-3">
                        <h3>New Audio Book</h3>
                        <div class="form-group">
                            <label class="form-label">Title</label>
                            <input type="text" name="title" class="form-control" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="mb-3">
                        <div class="form-group">
                            <label class="form-label">Author</label>
                            <input type="text" name="author" class="form-control" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="mb-3">
                        <div class="form-group">
                            <label class="form-label">Year</label>
                            <input type="text" name="book_year" class="form-control" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="mb-3">
                        <div class="form-group">
                            <label class="form-label">Language</label>
                            <select class="form-select" aria-label="Default select example" name="language">
                                <%
                                    ArrayList<Language> languages = DBManager.getLanguages();
                                    for(Language lan : languages){
                                %>
                                    <option value="<%=lan.getId()%>"><%=lan.getLan()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="mb-3">
                        <div class="form-group">
                            <label class="form-label">Voice</label>
                            <select class="form-select" aria-label="Default select example" name="voice">
                                <%
                                    ArrayList<Voice> voices = DBManager.getVoices();
                                    for(Voice voice : voices){
                                %>
                                <option value="<%=voice.getId()%>"><%=voice.getVoice()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <button  type="submit" class="btn btn-primary">Add New Audio Book</button>
                    </div>
                </form>
                <div class="form-group">
                    <a href="/indexLan" class="btn btn-primary">All Audio Books</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
