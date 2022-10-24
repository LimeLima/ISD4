package com.lime.servlets.User;

import com.lime.DB.DBManager;
import com.lime.DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User(request.getParameter("fullName"), request.getParameter("email"),
                request.getParameter("password"), request.getParameter("phone"));
        int id = Integer.parseInt(request.getParameter("id"));
        DBManager.updateUser(id, user);

        response.sendRedirect("/home?success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = DBManager.getUser(id);

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/Users/updateUser.jsp").forward(request, response);
        }

    }
}
