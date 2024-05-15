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
import java.util.Date;

@WebServlet(name = "ADMINGoodsDetailServlet",urlPatterns = "/admingoods_detail")
public class ADMINGoodsDetailServlet extends HttpServlet {
    OperationItemService opiService=new OperationItemService();
    GoodsService gService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int goodsid=0;
        String param=request.getParameter("goodsid");
        if(param!=null)
        {
            goodsid=Integer.parseInt(param);
        }
        Goods g=null;
        g=gService.getGoodsById(goodsid);
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());


        opitem.setOperation("管理人员"+user.getId()+"进入了商品"+g.getId()+"库存管理页面");

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
        request.getSession().setAttribute("g",g);
        request.getRequestDispatcher("admin_stock_add.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
}
