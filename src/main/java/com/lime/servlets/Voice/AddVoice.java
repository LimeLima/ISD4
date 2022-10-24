package com.lime.servlets.Voice;

import com.lime.DB.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addVoice")
public class AddVoice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String voice = request.getParameter("voice");

        DBManager.addVoice(voice);

        response.sendRedirect("/indexVoice?success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Voice/addVoice.jsp").forward(request, response);
    }
}
