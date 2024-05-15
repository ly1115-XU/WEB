package servlet;

import model.Goods;
import service.GoodsService;
import service.ViewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HotGoodsServlet",urlPatterns = "/hotgoods_list")
public class HotGoodsServlet extends HttpServlet {
    private ViewService vService=new ViewService();
    private GoodsService gService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer>idList=null;
        try {
            idList=vService.getGoodsid();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println(idList);
        List<Goods>list=new ArrayList<>();
//        assert idList != null;
        for(int id:idList)
        {
            Goods goods=null;
            goods=gService.getGoodsById(id);
//            System.out.println(goods);
            list.add(goods);
        }
//        System.out.println(list.size());
        request.getSession().setAttribute("list",list);
        request.getRequestDispatcher("/goods_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
