package servlet;

import model.Goods;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ADMINGoodsEditshowServlet",urlPatterns = "/admingoods_editshow")
public class ADMINGoodsEditshowServlet extends HttpServlet {
    private GoodsService gService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Goods g=gService.getGoodsById(id);
        request.setAttribute("g",g);
        request.getRequestDispatcher("admin_goods_edit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
