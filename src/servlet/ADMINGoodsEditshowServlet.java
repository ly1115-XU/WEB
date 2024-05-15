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

@WebServlet(name = "ADMINGoodsEditshowServlet",urlPatterns = "/admingoods_editshow")
public class ADMINGoodsEditshowServlet extends HttpServlet {
    private OperationItemService opiService=new OperationItemService();
    private GoodsService gService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Goods g=gService.getGoodsById(id);
        OperationItem opitem=new OperationItem();

        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());

        //opitem.setOperation("商品管理-销售人员"+user.getId()+"对于"+good.getType().getName()+"种类添加了新的商品");
        opitem.setOperation("商品管理-销售人员"+user.getId()+"对于商品"+g.getId()+"进行了修改");
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
        request.setAttribute("g",g);
        request.getRequestDispatcher("admin_goods_edit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}
