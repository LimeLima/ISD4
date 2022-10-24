package com.lime.servlets.Languages;

import com.lime.DB.AudioBook;
import com.lime.DB.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addLan")
public class AddLan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lang = request.getParameter("language");

        DBManager.addLanguage(lang);

        response.sendRedirect("/indexLan?success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Languages/addLan.jsp").forward(request, response);
    }
}
