package controller;

import dao.CRUD_Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;

@WebServlet(urlPatterns = "/edit-product")
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CRUD_Product crud_product = new CRUD_Product();
        Product product = crud_product.getSingleProduct(id);
        req.setAttribute("pr",product);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id1"));
        String nameP = req.getParameter("name1");
        int calo = Integer.parseInt(req.getParameter("calo1"));
        int price = Integer.parseInt(req.getParameter("price1"));

        int quantity = Integer.parseInt(req.getParameter("quantity1"));
        String img = req.getParameter("img1");

        CRUD_Product.edit(id,nameP,price,calo,quantity,img,0,"Con hang");
        resp.sendRedirect("/ProductServlet");
    }
}
