package servlet;

import model.Goods;
import model.Page;
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

@WebServlet("/goods_list")
public class GoodsListServlet extends HttpServlet {
    private TypeService tService = new TypeService();
    private GoodsService gService = new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数 typeid 如果为空，再去赋值，容易bug 进行判断是否为空
        int id=0;
        if(request.getParameter("typeid")!=null){
            id=Integer.parseInt(request.getParameter("typeid"));
        }
        //获取分页参数，判断是否为空
//        int pageNumber=0;
//        if(request.getParameter("pageNumber")!=null){
//            pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
//        }
        //根据typeid 查询type对象
        //将type对象放入范围
        Type t=null;
        if(id!=0){
            t = tService.selectTypeNameID(id);
        }
        request.setAttribute("t",t);

        //根据分页参数查询具体的商品数据
//        if(pageNumber<=0){
//            pageNumber=1;
//        }
//        Page page = gService.selectPageByTypeID(id,pageNumber);
        List<Goods>list=gService.selectGoodsByTypeID(id);
        //bug处理
//        if(page.getTotalPage()==0){
//            page.setTotalPage(1);
//            page.setPageNumber(1);
//        }
//        else{
//            //根据我们查询到的商品的数量进行分页
//            if(pageNumber>=page.getTotalPage()+1){
//                page=gService.selectPageByTypeID(id, page.getTotalPage());
//            }
//        }

        request.setAttribute("list",list);
        System.out.println(list.size());
        //将商品数据放入范围
        request.setAttribute("id",String.valueOf(id));
        //请求转发goods_list.jsp
        request.getRequestDispatcher("/goods_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
