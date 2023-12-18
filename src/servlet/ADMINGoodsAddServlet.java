package servlet;

import model.Goods;
import model.Type;
import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.GoodsService;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "GoodsAddServlet",urlPatterns = "/admingoods_add")
public class ADMINGoodsAddServlet extends HttpServlet {
    private GoodsService gService=new GoodsService();
    private TypeService tService=new TypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        new Disk
        //拿到前台数据，封装

        Goods good=new Goods();

        //request.getParameterMap()可以获取多个参数

        try {
            BeanUtils.copyProperties(good,request.getParameterMap());//自动进行封装
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        int typeid=Integer.parseInt(request.getParameter("typeid"));
        Type type=tService.select(typeid);
        good.setType(type);
//        System.out.println(good);
        //业务层
        GoodsService gService = new GoodsService();
        gService.insert(good);
        request.getRequestDispatcher("/admingoods_list").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
