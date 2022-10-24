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

@WebServlet("/addBook")
public class AddBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (DBManager.getLanguage(Integer.parseInt(request.getParameter("language"))) != null ||
                DBManager.getVoice(Integer.parseInt(request.getParameter("voice"))) != null) {
            AudioBook book = new AudioBook(request.getParameter("title"), request.getParameter("author"),
                    Integer.parseInt(request.getParameter("book_year")), Integer.parseInt(request.getParameter("language")),
                    Integer.parseInt(request.getParameter("voice")));
            DBManager.addAudioBook(book);

            response.sendRedirect("/indexBook?success");
        }
        else {
            request.getRequestDispatcher("/Languages/addLan.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/AudioBooks/addBook.jsp").forward(request, response);
    }
}
