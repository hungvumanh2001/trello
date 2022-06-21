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
            case "signin":
                showLogin(request, response);
                break;
            case "signup":
                showSignup(request, response);
                break;
            default:
                showHome(request, response);
        }

}


    private void showSignup(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher  = request.getRequestDispatcher("user/signup.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher  = request.getRequestDispatcher("user/signin.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher  = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null)
        {
            action ="";
        }
        switch (action)
        {
            case "signin":
                checkLogin(request, response);
                break;
            case "signup":
                checkSignup(request, response);
                break;
            default:
                showHome(request, response);
        }
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = this.trelloServicelmpl.checkLogin(username, password);
        if (user == null){

        }
        else {
            RequestDispatcher requestDispatcher  = request.getRequestDispatcher("index.jsp");
            session.setAttribute("user", user);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void checkSignup(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 10000);
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String repass = request.getParameter("re_pass");
        if(username!=null&&email!=null&&password!=null&&repass!=null){
            if (password.equals(repass)){
                User user = new User(id, username, password, email, null, null, null, "user", "active");
                this.trelloServicelmpl.add(user);
                RequestDispatcher requestDispatcher  = request.getRequestDispatcher("index.jsp");
                try {
                    requestDispatcher.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
