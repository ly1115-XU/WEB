package servlet;

import model.Goods;
import service.GoodsService;
import service.TypeService;
import service.ViewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ADMINGoodsStatueServlet",urlPatterns = "/admingoods_statue")
public class ADMINGoodsStatueServlet extends HttpServlet {
    ViewService vService=new ViewService();
    TypeService tService=new TypeService();
    GoodsService gService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeid=Integer.parseInt(request.getParameter("type"));
        List<Goods> goodsList=null;
        goodsList=gService.selectGoodsByTypeID(typeid);
        request.getSession().setAttribute("goodsList",goodsList);
        request.getRequestDispatcher("admin_goods_statue.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
