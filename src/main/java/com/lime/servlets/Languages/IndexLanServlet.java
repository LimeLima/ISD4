package com.lime.servlets.Languages;

import com.lime.DB.AudioBook;
import com.lime.DB.DBManager;
import com.lime.DB.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/indexLan")
public class IndexLanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Language> languages =  DBManager.getLanguages();

        request.setAttribute("yazyki", languages);

        request.getRequestDispatcher("/Languages/indexLan.jsp").forward(request, response);
    }
}
