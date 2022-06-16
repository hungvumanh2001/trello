package controller;

import model.User;
import service.TrelloServicelmpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TrelloServlet", value = "/trellos")
public class TrelloServlet extends HttpServlet {
    TrelloServicelmpl trelloServicelmpl = new TrelloServicelmpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null)
        {
            action ="";
        }
        switch (action)
        {
            default:
                showListUser(request,response);
        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher  = request.getRequestDispatcher("list.jsp");
        List<User> users = trelloServicelmpl.findAll();
        request.setAttribute("listUser",users);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
