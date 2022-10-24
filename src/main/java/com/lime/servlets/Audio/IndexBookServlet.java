package com.lime.servlets.Audio;

import com.lime.DB.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/indexBook")
public class IndexBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<AudioBook> books =  DBManager.getBooks();

        request.setAttribute("knigi", books);

        request.getRequestDispatcher("/AudioBooks/indexBook.jsp").forward(request, response);

    }
}
