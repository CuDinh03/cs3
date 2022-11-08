package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import service.ProductService;

import java.io.IOException;

@WebServlet(urlPatterns = "/addProduct")
public class CreateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int calo = Integer.parseInt(req.getParameter("calo"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String img = req.getParameter("img");

        if (name.isEmpty()|| price == 0 || calo == 0|| quantity == 0 || img.isEmpty() ){

        }else {
            ProductService.create(new Product(name,price,calo,quantity,img,0,"Sẵn Hàng"));
            resp.sendRedirect("/addProduct.jsp");
        }
    }
}
