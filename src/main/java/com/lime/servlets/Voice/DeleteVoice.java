package com.lime.servlets.Voice;

import com.lime.DB.DBManager;
import com.lime.DB.Language;
import com.lime.DB.Voice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/deleteVoice")
public class DeleteVoice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DBManager.deleteVoice(id);

        ArrayList<Voice> voices =  DBManager.getVoices();

        request.setAttribute("golosa", voices);

        request.getRequestDispatcher("/Voice/indexVoice.jsp").forward(request, response);
    }
}
