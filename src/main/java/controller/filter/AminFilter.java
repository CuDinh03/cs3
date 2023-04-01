//package controller.filter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import model.User;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebFilter(urlPatterns = "/adminView.jsp")
//public class AminFilter extends HttpFilter {
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpSession session = req.getSession();
//        User user= (User) session.getAttribute("user");
//        if (user == null) {
//            res.sendRedirect("/login");
//        } else if (user.getRole() == 1) {
//            chain.doFilter(req,res);
//        } else {
//            PrintWriter printWriter = res.getWriter();
//            printWriter.println("<h1>Quyền user Không có quyền truy cập</h1>");
//        }
//    }
//}
