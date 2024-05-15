package servlet;

import model.*;
import service.GoodsService;
import service.OperationItemService;
import service.TypeService;
import service.ViewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ADMINViewListServlet",urlPatterns = "/adminview_list")
//@WebServlet(name = "GoodsAddServlet",urlPatterns = "/admingoods_add")
public class ADMINViewListServlet extends HttpServlet {

    private ViewService vService=new ViewService();
    private TypeService tService=new TypeService();
    private GoodsService gService=new GoodsService();
    private OperationItemService opiService=new OperationItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeid=Integer.parseInt(request.getParameter("type"));
//        try {
//            vService.getViewListByTypeId(typeid);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        List<View> ViewList=null;

        try {
                ViewList=vService.getViewListByTypeId(typeid);//根据typeid拿到浏览记录
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//            if(ViewList==null)
//            {
//                System.out.println("viewlist为空");
//            }
//            if (ViewList != null) {
//                for (View view : ViewList) {
//                    int goodsid = view.getGoodsid();
//                    System.out.println("goodsid"+goodsid);
//                    int type_id = view.getTypeid();
//                    System.out.println("typeid"+type_id);
//                    Goods goods=gService.getGoodsById(goodsid);
//                    Type type=tService.select(type_id);
//                    view.setType(type);
//                    view.setGoods(goods);
////                    int amount = view.getAmount();
//
//                    // 在这里对每个 View 对象中的 Goods, Type 和 amount 进行操作
//                }


//        List<Type>typeList=tService.getAllType();
//        Type typename=tService.selectTypeNameID(typeid);
//        String typename=null;
//        try {
//           typename=tService.getTypeNameByID(typeid);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        List<Goods>GoodsList=null;
//        GoodsList=gService.selectGoodsByTypeID(typeid);
//        List<Goods>goodsList=gService.selectGoodsByTypeID(typeid);
        OperationItem opitem=new OperationItem();

        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());

        try {
            opitem.setOperation("浏览记录-销售人员"+user.getId()+"查看了"+tService.getTypeNameByID(typeid)+"浏览记录");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        request.getSession().setAttribute("ViewList",ViewList);
//        System.out.println(typename+"?");
//        request.getSession().setAttribute("typename",typename);
//        request.getSession().setAttribute("goodslist",GoodsList);
        request.getRequestDispatcher("admin_view_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
