package servlet;

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

@WebServlet(name = "ADMINGoodsDeleteServlet",urlPatterns = "/admingoods_delete")
public class ADMINGoodsDeleteServlet extends HttpServlet {
    private GoodsService gService=new GoodsService();
    private OperationItemService opiService=new OperationItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        gService.delete(id);
//        int typeid=Integer.parseInt(request.getParameter("typeid"));
        User user=(User)request.getSession().getAttribute("user");
        int typeid=user.getAdmintype();
        OperationItem opitem=new OperationItem();

        opitem.setOp_datetime(new Date());
//        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());

        opitem.setOperation("商品管理-销售人员"+user.getId()+"删除了商品"+id);

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
        request.getRequestDispatcher("/admingoods_list?type="+typeid).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
}
