package servlet;

import model.Goods;
import model.Type;
import model.User;
import model.View;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GoodsDetailServlet",urlPatterns = "/goods_detail")
public class GoodsDetailServlet extends HttpServlet {
    private GoodsService gService=new GoodsService();
    private RecommendGoodsService rgService=new RecommendGoodsService();
    private ViewService vService=new ViewService();
    private TypeService tService=new TypeService();
    private OperationItemService opiService=new OperationItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Goods g=gService.getGoodsById(id);
        Type type=tService.selectByGoodsId(g.getId());
        User user=(User)request.getSession().getAttribute("user");
        View view=new View();
        view.setGoods(g);
        if(user!=null)
        {
            try {
                if(!user.isIsmanage()&&!user.isIsadmin())
                {
                    rgService.updateViewPer(user.getId(),g.getId());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        view.setAmount(1);

//        System.out.println(g.getType());
        view.setType(type);

//        view.setTypeid(g.getType().getId());
//        if (view != null && g != null && g.getType() != null) {
//            view.setTypeid(g.getType().getId());
//        } else {
//            // 处理空指针异常的逻辑
//            System.out.println("空指针错误" );
//        }

        try {
            vService.addView(view);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("g",g);
//        request.getSession().setAttribute("typename",type.getName());
        request.getRequestDispatcher("/goods_detail.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
