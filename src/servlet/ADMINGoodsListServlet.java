package servlet;

import model.Goods;
import model.Type;
import service.GoodsService;
import service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ADMINGoodsListServlet",urlPatterns = "/admingoods_list")
public class ADMINGoodsListServlet extends HttpServlet {
    private GoodsService gService=new GoodsService();
    private TypeService tService=new TypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.getSession().setAttribute("list",list);
        request.getSession().setAttribute("typeList",typeList);
        request.getRequestDispatcher("admin_goods_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
