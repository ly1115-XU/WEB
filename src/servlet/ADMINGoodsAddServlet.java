package servlet;

import model.Goods;
import model.OperationItem;
import model.Type;
import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.GoodsService;
import service.OperationItemService;
import service.RecommendGoodsService;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "GoodsAddServlet",urlPatterns = "/admingoods_add")
public class ADMINGoodsAddServlet extends HttpServlet {
    private GoodsService gService=new GoodsService();
    private TypeService tService=new TypeService();
    RecommendGoodsService rgService=new RecommendGoodsService();
    private OperationItemService opiService=new OperationItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        new Disk
        //拿到前台数据，封装

        Goods good=new Goods();

        //request.getParameterMap()可以获取多个参数

        try {
            BeanUtils.copyProperties(good,request.getParameterMap());//自动进行封装
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        User user=(User)request.getSession().getAttribute("user");
        int typeid=user.getAdmintype();
//        int typeid=Integer.parseInt(request.getParameter("typeid"));
        Type type=tService.select(typeid);
        good.setType(type);
//        System.out.println(good);
        //业务层
        GoodsService gService = new GoodsService();
        gService.insert(good);
        try {
            int goods_id=gService.getLstId();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            rgService.addGoods(good.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        OperationItem opitem=new OperationItem();

        opitem.setOp_datetime(new Date());
//        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());

        opitem.setOperation("商品管理-销售人员"+user.getId()+"对于"+good.getType().getName()+"种类添加了新的商品");

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
