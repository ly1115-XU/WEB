package servlet;

import model.Goods;
import model.OperationItem;
import model.User;
import service.GoodsService;
import service.OperationItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "ADMINStockAddServlet",urlPatterns = "/adminstock_add")
public class ADMINStockAddServlet extends HttpServlet {
    OperationItemService opiService =new OperationItemService();
    GoodsService gService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stockadd=0;
//        System.out.println(1);
        String param=request.getParameter("stock");
        Goods g=null;
        g=(Goods)request.getSession().getAttribute("g");
        if(param!=null)
        {
            stockadd=Integer.parseInt(param);
//            System.out.println(stockadd);
        }
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());

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

        if(stockadd<0)
        {
            request.setAttribute("failMsg","添加库存数目不可为负，请重新添加");
            opitem.setOperation("管理人员"+user.getId()+"对商品"+g.getId()+"进行库存添加但失败");
            opiService.addOperationItem(opitem);
//            System.out.println("failed");
            request.getRequestDispatcher("admin_stock_add.jsp").forward(request,response);
        }
        try {
            gService.UpdateStock(stockadd,g.getId());
//            System.out.println(g.getId());
            request.setAttribute("msg","添加库存成功");
            opitem.setOperation("销售统计+管理人员"+user.getId()+"对商品"+g.getId()+"进行库存添加且成功");
            opiService.addOperationItem(opitem);
//            response.sendRedirect(request.getContextPath()+"/adminsale_stats");
            request.getRequestDispatcher("/adminsale_stats").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
