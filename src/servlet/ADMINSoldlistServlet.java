package servlet;

import model.Goods;
import model.Order;
import model.OrderItem;
import model.Sold;
import service.GoodsService;
import service.OrderItemService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ADMINSoldlistServlet",urlPatterns = "/adminorderitems")
public class ADMINSoldlistServlet extends HttpServlet {
    OrderItemService oiService=new OrderItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeid=0;
        List<Sold>oilist=null;
        if(request.getParameter("type")!=null)
        {
            typeid=Integer.parseInt(request.getParameter("type"));
        }
        try {
            oilist=oiService.getOrderItemListByID(typeid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println(list);
//        System.out.println(list.get(0).getId());

//        System.out.println(list);
//        System.out.println(list.get(0).getId());
//        double totalamount=0.0;
//        try {
//            totalamount=oiService.gettotalamount(typeid);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        double totalprice=0.0;
//        for(int i=0;i< oilist.size();i++)
//        {
////            try {
////                int goodsid=oiService.getGoodsid(list.get(i).getId());
////                GoodsService gService = new GoodsService();
////                Goods goods=gService.getGoodsById(goodsid);
////                list.get(i).setGoods(goods);
////                list.get(i).setType(goods.getType());
////                int orderid=oiService.getOrderid(list.get(i).getId());
////                OrderService oService=new OrderService();
////                Order order=oService.getOrderById(orderid);
////                list.get(i).setOrder(order);
////            } catch (SQLException throwables) {
////                throwables.printStackTrace();
////            }
//            totalprice+=oilist.get(i).getPrice()*oilist.get(i).getAmount();
//        }
//        System.out.println(list);
//        System.out.println(totalamount);
//        System.out.println(totalprice);
        request.setAttribute("oilist",oilist);
//        request.setAttribute("totalamount",totalamount);
//        request.setAttribute("totalprice",totalprice);
        request.getRequestDispatcher("admin_sold.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
