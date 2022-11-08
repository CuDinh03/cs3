package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/signup")
public class ControllerUsercreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameUser");

        String username = req.getParameter("users");
        String password = req.getParameter("pasw");
        String contact = req.getParameter("contact");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String img = req.getParameter("img");


        UserService.create(new User(name,username,password,contact,address,email,img, 0, 0));
        resp.sendRedirect("/login.jsp");
    }
}
