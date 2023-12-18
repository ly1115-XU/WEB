package servlet;

import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ADMINOrderStatusServlet",urlPatterns = "/adminorder_status")
public class ADMINOrderStatusServlet extends HttpServlet {
    private OrderService oService=new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        int status=Integer.parseInt(request.getParameter("status"));
        oService.updateStatus(id,status);
        response.sendRedirect(request.getContextPath()+"/adminorder_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
