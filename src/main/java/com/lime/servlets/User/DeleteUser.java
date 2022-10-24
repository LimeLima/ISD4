package com.lime.servlets.User;

import com.lime.DB.DBManager;
import com.lime.DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DBManager.deleteUser(id);

        ArrayList<User> users = DBManager.getUsers();
        request.setAttribute("polzovateli", users);
        request.getRequestDispatcher("/Users/index.jsp").forward(request, response);
    }
}
