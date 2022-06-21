package controller;

import model.Post;
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
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                showListUser(request,response);

        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Post post = this.trelloServicelmpl.findById(id);
//        RequestDispatcher dispatcher;
//        if(post == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            request.setAttribute("spCanXoa", post);
//            dispatcher = request.getRequestDispatcher("delete.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = trelloServicelmpl.findById(id);
        request.setAttribute("spCanXoa",post);
        requestDispatcher.forward(request,response);
    }

    private void showListPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher requestDispatcher  = request.getRequestDispatcher("listPost.jsp");
        List<Post> posts = trelloServicelmpl.findAllPost();
        request.setAttribute("listPost",posts);
        requestDispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = this.trelloServicelmpl.findById(id);
        RequestDispatcher dispatcher;
        if(post == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("spCanSua", post);
            dispatcher = request.getRequestDispatcher("edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher requestDispatcher  = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        List<User> users = trelloServicelmpl.findAll();
        List<Post> posts = trelloServicelmpl.findAllPost();
        if (key != null)
        {
            posts = this.trelloServicelmpl.findByName(key);
        }
        RequestDispatcher requestDispatcher  = request.getRequestDispatcher("list.jsp");

        request.setAttribute("listUser",users);
        request.setAttribute("listPost",posts);
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
            case "create":
                createForm(request,response);
                break;
            case "edit":
                updateForm(request, response);
                break;
            case "delete":
                deletePost(request, response);
                break;

        }
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Post post = this.trelloServicelmpl.findById(id);
//        RequestDispatcher dispatcher;
//        if(post == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            this.trelloServicelmpl.remove(id);
//            try {
//                response.sendRedirect("/trellos");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = this.productService.findById(id);
        trelloServicelmpl.delete(id);
        response.sendRedirect("/trellos");
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        int id = Integer.parseInt(request.getParameter("id"));
//        String title = request.getParameter("title");
//        int dateCreated = Integer.parseInt(request.getParameter("dateCreated"));
//        String content = request.getParameter("content");
//        String description = request.getParameter("description");
//        String authority = request.getParameter("authority");
//        String status = request.getParameter("status");
//        String userid = request.getParameter("userid");
//        String typeid = request.getParameter("typeid");
//        Post post = this.trelloServicelmpl.findById(id);
//        RequestDispatcher dispatcher;
//        if(post == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            post.setTitle(title);
//            post.setDateCreated(dateCreated);
//            post.setContent(content);
//            post.setDescription(description);
//            post.setAuthority(authority);
//            post.setStatus(status);
//            post.setUserid(userid);
//            post.setTypeid(typeid);
//            this.trelloServicelmpl.update(id, post);
//            request.setAttribute("spCanSua", post);
//            request.setAttribute("message", "Post information was updated");
//            dispatcher = request.getRequestDispatcher("edit.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int dateCreated = Integer.parseInt(request.getParameter("dateCreated"));
        String content = request.getParameter("content");
        String description = request.getParameter("description");
        String authority = request.getParameter("authority");
        String status = request.getParameter("status");
        String userid = request.getParameter("userid");
        String typeid = request.getParameter("typeid");
        trelloServicelmpl.update(id,new Post(id,title,dateCreated,content,description,authority,status,userid,typeid));
        response.sendRedirect("/trellos");
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int dateCreated = Integer.parseInt(request.getParameter("dateCreated"));
        String content = request.getParameter("content");
        String description = request.getParameter("description");
        String authority = request.getParameter("authority");
        String status = request.getParameter("status");
        String userid = request.getParameter("userid");
        String typeid = request.getParameter("typeid");
       trelloServicelmpl.save(new Post(id,title,dateCreated,content,description,authority,status,userid,typeid));
       response.sendRedirect("/trellos");

    }
}
