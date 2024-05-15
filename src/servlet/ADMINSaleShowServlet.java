package servlet;

import model.OperationItem;
import model.Sale;
import model.User;
import service.OperationItemService;
import service.OrderItemService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ADMINSaleShowServlet",urlPatterns = "/adminsale_show")
public class ADMINSaleShowServlet extends HttpServlet {
//    @Autowired
    OperationItemService opiService = new OperationItemService();
    UserService uService=new UserService();
//    OrderService oService=new OrderService();
    OrderItemService oiService = new OrderItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User>userList=new ArrayList<>();
        try {
            userList=uService.getAdminUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Sale>saleList=new ArrayList<>();
//        System.out.println(userList);
        int tag=0;
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            Sale sale=new Sale();
            int typeid=user.getAdmintype();
            tag++;
            int amount = 0;
            try {
                if (oiService != null) {
                    amount = oiService.gettotalamount(typeid);
                } else {
                    // 处理 oiService 或者 typeid 为 null 的情况
                    // 可以抛出异常或者采取其他适当的处理方式
                    System.out.println("oiService为空");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//            System.out.println(typeid);
//            System.out.println(amount);
//            System.out.println(tag);
            sale.setAmount(amount);
            sale.setUser(user);
            saleList.add(sale);
//            System.out.println(saleList);
        }
//        System.out.println(saleList);

        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());


        opitem.setOperation("销售业绩-管理员"+user.getId()+"查看了销售业绩");

        String ip_address=null;
//        AdminBigdata abd=null;
        if(request.getHeader("x-forwarded-for")==null)
        {
            ip_address=request.getRemoteAddr();
        }
        else
        {
            ip_address=request.getHeader("x-forwarded-for");
        }
        opitem.setIp_address(ip_address);
        opiService.addOperationItem(opitem);

        request.getSession().setAttribute("saleList",saleList);

        request.getRequestDispatcher("admin_sale_show.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
