package controller;

import dao.BillDao;
import dao.BillDetailDao;
import dao.CRUD_Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;
import service.CartService;

import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User User = (User) session.getAttribute("User");
        CartService cartService = new CartService();
        double tongTien = 0;
        for (int i = 0; i < cartService.carts.size(); i++) {
            tongTien += cartService.carts.get(i).getTotalPrice();
        }

        BillDao.save(new Bill(User.getIdUser(), tongTien));
        int idBill = BillDao.findIdMax();

        for (int i = 0; i < cartService.carts.size(); i++) {
            BillDetail billDetail = new BillDetail(cartService.carts.get(i).getAmount(), cartService.carts.get(i).getIdProduct(), idBill);
            BillDetailDao.save(billDetail);
        }
        cartService.reset();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        int soLuong = Integer.parseInt(request.getParameter("number"));

        Product product = CRUD_Product.FindProductById(id);
        Cart cart = new Cart(id, soLuong, soLuong * product.getPrice());

//        HttpSession session = req.getSession();
//        ArrayList<Cart> gioHang = (ArrayList<Cart>) session.getAttribute("carts");
//        if(gioHang == null) {
//            gioHang = new ArrayList<>();
//        }
//        gioHang.add(cart);
//        session.setAttribute("carts", gioHang);

        CartService cartService = new CartService();
        cartService.add(cart);

        request.setAttribute("carts", cartService.carts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Cart.jsp");
        dispatcher.forward(request, response);
    }
}

