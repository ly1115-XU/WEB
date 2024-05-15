package servlet;

import model.Goods;
import model.Type;
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

@WebServlet(name = "ADMINGoodsEditServlet",urlPatterns = "/admingoods_edit")
public class ADMINGoodsEditServlet extends HttpServlet {
    private GoodsService gService=new GoodsService();
    private TypeService tService=new TypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Goods good=new Goods();

        //request.getParameterMap()可以获取多个参数

        try {
            BeanUtils.copyProperties(good,request.getParameterMap());//自动进行封装
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(good);
        int typeid=Integer.parseInt(request.getParameter("typeid"));
        Type type=tService.select(typeid);
        good.setType(type);
//        System.out.println(good);
        gService.update(good);

        request.getRequestDispatcher("/admingoods_list?type="+typeid).forward(request,response);
//        request.send
//        response.sendRedirect(request.getContextPath()+"/admingood_list?type="+typeid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}
