package servlet;

import model.GoodsSale;
import model.OperationItem;
import model.User;
import service.OperationItemService;
import service.OrderItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ADMINSaleStatsServlet",urlPatterns = "/adminsale_stats")
public class ADMINSaleStatsServlet extends HttpServlet {
    OperationItemService opiService =new OperationItemService();
    OrderItemService oiService=new OrderItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeid=0;
        String param=null;
        param=request.getParameter("typeid");
        if(param!=null)
        {
            typeid=Integer.parseInt(param);
        }
//        typeid=Integer.parseInt(request.getParameter("typeid"));
        List<GoodsSale> ssList=null;
        try {
            ssList=oiService.getOrderItemByTypeIDStats(typeid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());
        String type=null;
        if(typeid==0)
        {
            type="全部商品";
        }
        else if(typeid==1)
        {
            type="饼干";
        }
        else if(typeid==2)
        {
            type="蛋糕";
        }
        else if(typeid==3)
        {
            type="饮品";
        }
        else if(typeid==4)
        {
            type="其他种类";
        }
        opitem.setOperation("销售统计-管理员"+user.getId()+"查看了"+type+"种类的商品销售统计");

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
//        System.out.println(ssList);
        request.getSession().setAttribute("ssList",ssList);
        request.getRequestDispatcher("admin_sale_stats.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
