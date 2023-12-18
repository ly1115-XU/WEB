package servlet;

import model.Page;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "GoodsSearchServlet",urlPatterns = "/goods_search")
public class GoodsSearchServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        int pageNumber=1;
        if(request.getParameter("keyword")!=null){
            pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
        }
        if(pageNumber<=0){
            pageNumber=1;
        }
        Page p=gService.getSearchGoodsPage(keyword,pageNumber);
        if(p.getTotalPage()==0)
        {
            p.setTotalCount(1);
            p.setPageNumber(1);
        }
        else{
            if(pageNumber>=p.getTotalPage()+1){
                p=gService.getSearchGoodsPage(keyword,pageNumber);
            }
        }
        request.setAttribute("p",p);
        request.setAttribute("keyword", URLEncoder.encode(keyword,"utf-8"));
        request.getRequestDispatcher("/goods_search.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
