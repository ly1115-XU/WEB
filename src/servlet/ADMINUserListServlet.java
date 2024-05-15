package servlet;

import model.OperationItem;
import model.Type;
import model.User;
import service.OperationItemService;
import service.TypeService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ADMINUserListServlet",urlPatterns = "/adminuser_list")
public class ADMINUserListServlet extends HttpServlet {
    private OperationItemService opiService=new OperationItemService();
    private UserService uService=new UserService();
    private TypeService tService=new TypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int pageNumber = 1;
//        if(request.getParameter("pageNumber")!=null)
//        {
//            pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
//        }
        List<User> list=null;
        try {
            list=uService.getAdminUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Type>typeList=null;
        typeList=tService.getAllType();
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());
        String order_id=request.getParameter("id");
        opitem.setOperation("销售人员管理-管理员"+user.getId()+"进行查看");

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
        request.getSession().setAttribute("list",list);
        request.getSession().setAttribute("typeList",typeList);
        request.getRequestDispatcher("admin_user_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
