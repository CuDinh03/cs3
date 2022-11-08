//package controller.filter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//import model.User;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//@WebServlet(urlPatterns = "/editinfo.jsp")
//public class edituserfilter extends HttpFilter {
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException, IOException, ServletException {
//        HttpSession session = req.getSession();
//        User user= (User) session.getAttribute("user");
//        if (user == null) {
//            res.sendRedirect("/login");
//        } else if (user.getRole() == 0) {
//            chain.doFilter(req,res);
//        } else {
//            PrintWriter printWriter = res.getWriter();
//            printWriter.println("<h1>Quyền Admin Không có quyền truy cập</h1>");
//        }
//    }
//}
