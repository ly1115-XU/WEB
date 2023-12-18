package servlet;

import model.Order;
import model.Page;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ADMINOrderListServlet",urlPatterns = "/adminorder_list")
public class ADMINOrderListServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status=0;
        if(request.getParameter("status")!=null){
            status=Integer.parseInt(request.getParameter("status"));
        }
        request.setAttribute("status",status);
//        int pageNumber=1;
//        if(request.getParameter("pageNumber")!=null){
//            pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
//        }
//        if(pageNumber<=0)
//        {
//            pageNumber=1;
//        }
//        Page p=oService.getOrderPage(status,pageNumber);
//        if(p.getTotalPage()==0)
//        {
//            p.setTotalPage(1);
//            p.setPageNumber(1);
//        }
//        else{
//            if(pageNumber>=p.getTotalPage()+1)
//            {
//                p=oService.getOrderPage(status,pageNumber);
//            }
//        }
        List<Order> list=oService.getOrder(status);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/admin_order_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
