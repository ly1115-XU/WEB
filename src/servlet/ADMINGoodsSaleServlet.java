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

@WebServlet(name = "ADMINGoodsSaleServlet",urlPatterns = "/admingoods_sale")
public class ADMINGoodsSaleServlet extends HttpServlet {
    OperationItemService opiService=new OperationItemService();
    OrderItemService oiService=new OrderItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int typeid=0;
        typeid=Integer.parseInt(request.getParameter("typeid"));
        List<GoodsSale> gsList=null;
        try {
            gsList=oiService.getOrderItemListByTypeID(typeid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println(gsList);
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());
        String type=null;
        if(typeid==1)
        {
            type="饼干";
        }
        else if(typeid==2)
        {
            type="蛋糕";
        }
        else if(typeid==3)
        {
            type="饮料";
        }
        else if(typeid==4)
        {
            type="其他";
        }
        opitem.setOperation("销售业绩-管理员"+user.getId()+"查看了种类-"+type+"的销售业绩");

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
        request.getSession().setAttribute("gsList",gsList);
        request.getRequestDispatcher("admin_goods_sale.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
}
// type="其他";
// type="其他";