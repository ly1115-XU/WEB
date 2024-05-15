package servlet;

import model.OperationItem;
import model.User;
import service.OperationItemService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ADMINOrderStatusServlet",urlPatterns = "/adminorder_status")
public class ADMINOrderStatusServlet extends HttpServlet {
    private OperationItemService opiService = new OperationItemService();
    private OrderService oService=new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());
        String param=null;
        param=request.getParameter("status");
        String order_id=request.getParameter("id");
        if(param.equals("3"))
        {
            //opitem.setOperation("订单管理-管理员"+user.getId()+"对订单"+order_id+"进行了发货");
            if(user.isIsmanage())
            {
                opitem.setOperation("订单管理-管理员"+user.getId()+"查看了所有订单");
            }
            else if(user.isIsadmin())
            {
                opitem.setOperation("订单管理-销售人员"+user.getId()+"查看了所有订单");
            }
        }
        else if(param.equals("4"))
        {
            //opitem.setIp_address("订单管理-管理员"+user.getId()+"完成了订单"+order_id+"");
            if(user.isIsmanage())
            {
                opitem.setOperation("订单管理-管理员"+user.getId()+"完成了订单"+order_id);
            }
            else if(user.isIsadmin())
            {
                opitem.setOperation("订单管理-销售人员"+user.getId()+"完成了订单"+order_id);
            }
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
        int id=Integer.parseInt(request.getParameter("id"));
        int status=Integer.parseInt(request.getParameter("status"));
        oService.updateStatus(id,status);
        response.sendRedirect(request.getContextPath()+"/adminorder_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
