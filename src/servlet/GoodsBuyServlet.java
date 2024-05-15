package servlet;

import model.Goods;
import model.Order;
import model.Type;
import model.User;
import service.GoodsService;
import service.RecommendGoodsService;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GoodsBuyServlet",urlPatterns = "/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
    private GoodsService gService=new GoodsService();
    private RecommendGoodsService rgService=new RecommendGoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("进行到了post");
        //1. 声明车
        Order o=null;
        //2. 第一次登录没有车，创建车
           //第二次有了
        //保存在会话层
        if(request.getSession().getAttribute("order")!=null){
             o = (Order)request.getSession().getAttribute("order");
        }else{
            o=new Order();
        }
       // o=new Order();?如果ssession中没有则应该创建一个，而不是每次都创建吧
        request.getSession().setAttribute("order",o);
        //3.获取前台的参数 goodsid查询商品信息
        User user=(User)request.getSession().getAttribute("user");
        int goodsid = Integer.parseInt(request.getParameter("goodsid"));
        Goods goods = gService.getGoodsById(goodsid);
        try {
            rgService.updateBuyPre(user.getId(),goods.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        System.out.println(goods);
        TypeService tService=new TypeService();
        Type type=tService.selectByGoodsId(goodsid);
//        Type type=
        goods.setType(type);
//        System.out.println(goods);

        //加入购物车 库存问题
//        System.out.println(goods.getStock());
//        System.out.println(o.getAmount());
        if(goods.getStock()>0)//库存大于0，加入购物车
        {
            if(!o.addGoods(goods))
            {
                request.getSession().setAttribute("failMsg","库存不足！");
            }
        }
        request.getSession().setAttribute("order",o);
        response.getWriter().print("ok");
//        System.out.println("在购买时是否有数据："+o.getAddress());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("进行到了doget");
        this.doPost(request,response);
    }
}
