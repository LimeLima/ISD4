package com.lime.servlets.Audio;

import com.lime.DB.AudioBook;
import com.lime.DB.DBManager;
import com.lime.DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateBook")
public class UpdateBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AudioBook book = new AudioBook(request.getParameter("title"), request.getParameter("author"),
                Integer.parseInt(request.getParameter("book_year")), Integer.parseInt(request.getParameter("language")),
                Integer.parseInt(request.getParameter("voice")));
        DBManager.updateBook(Integer.parseInt(request.getParameter("id")), book);

        response.sendRedirect("/indexBook?success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AudioBook book = DBManager.getBook(id);

        if (book != null) {
            request.setAttribute("book", book);
            request.getRequestDispatcher("/AudioBooks/updateBook.jsp").forward(request, response);
        }

    }
}
