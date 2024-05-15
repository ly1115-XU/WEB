package servlet;

import model.*;
import service.OperationItemService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ADMINOrderListServlet",urlPatterns = "/adminorder_list")
public class ADMINOrderListServlet extends HttpServlet {
    private OperationItemService opiService=new OperationItemService();
    private OrderService oService = new OrderService();
//    private OperationItemService opiService=new OperationItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        OperationItem opitem=new OperationItem();
        int status=0;
        if(request.getParameter("status")!=null){
            status=Integer.parseInt(request.getParameter("status"));
        }
        request.setAttribute("status",status);
        List<Order> list=oService.getOrder(status);
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());
        String order_id=request.getParameter("id");
        if(user.isIsmanage())
        {
            opitem.setOperation("订单管理-管理员"+user.getId()+"查看了所有订单");
        }
        else if(user.isIsadmin())
        {
            opitem.setOperation("订单管理-销售人员"+user.getId()+"查看了所有订单");
        }

        String ip_address=null;
//        AdminBigdata abd=null;
        if(request.getHeader("x-forwarded-for")==null)
        {
            ip_address=request.getRemoteAddr();
        }
        else
        {
            ip_address=request.getHeader("x-forwarded-for");
        }
        opitem.setIp_address(ip_address);
        opiService.addOperationItem(opitem);
        request.setAttribute("list",list);
        request.getRequestDispatcher("admin_order_list.jsp").forward(request,response);
    }
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
