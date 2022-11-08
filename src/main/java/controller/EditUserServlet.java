package controller;

import dao.CRUD_User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet(urlPatterns = "/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CRUD_User crud_user = new CRUD_User();
        User user = crud_user.getUserByIdD(id);
        req.setAttribute("st",user);
        req.getRequestDispatcher("editinfo.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("nameuser1");
        String email = req.getParameter("email1");
        String phone = req.getParameter("contact1");
        String img = req.getParameter("img1");
        String address = req.getParameter("address1");

        CRUD_User.edit(id, name,email,phone,img,address);
        resp.sendRedirect("login");


    }

}
