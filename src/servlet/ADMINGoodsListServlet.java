package servlet;

import model.Goods;
import model.OperationItem;
import model.Type;
import model.User;
import service.GoodsService;
import service.OperationItemService;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ADMINGoodsListServlet",urlPatterns = "/admingoods_list")
public class ADMINGoodsListServlet extends HttpServlet {
    private OperationItemService opiService=new OperationItemService();
    private GoodsService gService=new GoodsService();
    private TypeService tService=new TypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        int id=0;
//        if(request.getSession())
//        gService.getGoodsById();
        int type=0;
        String typeParam = request.getParameter("type");
        if(typeParam != null && !typeParam.isEmpty()){
            type=Integer.parseInt(typeParam);
        }
        List<Type>typeList=tService.getAllType();


        List<Goods> list=null;
        list=gService.selectGoodsByTypeID(type);
//        System.out.println(list);
        OperationItem opitem=new OperationItem();

        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());

        opitem.setOperation("商品管理-销售人员"+user.getId()+"查看了商品管理");

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
        request.getSession().setAttribute("list",list);
        request.getSession().setAttribute("typeList",typeList);
        request.getSession().setAttribute("type_id",type);
        request.getRequestDispatcher("admin_goods_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}
