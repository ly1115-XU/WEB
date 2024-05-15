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

@WebServlet(name = "ADMINOrderDeleteServlet",urlPatterns = "/adminorder_delete")
public class ADMINOrderDeleteServlet extends HttpServlet {
    private OperationItemService opiService=new OperationItemService();
    private OrderService oService=new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OperationItem opitem=new OperationItem();
        int id=Integer.parseInt(request.getParameter("id"));
        oService.delete(id);

        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());
        String param=null;
        param=request.getParameter("status");

        //opitem.setOperation("订单管理-管理员"+user.getId()+"删除了订单"+id);
        if(user.isIsmanage())
        {
            opitem.setOperation("订单管理-管理员"+user.getId()+"删除了订单"+id);
        }
        else if(user.isIsadmin())
        {
            opitem.setOperation("订单管理-销售人员"+user.getId()+"删除了订单"+id);
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
        request.getRequestDispatcher("/adminorder_list").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
