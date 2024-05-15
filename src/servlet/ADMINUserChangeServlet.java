package servlet;

import model.OperationItem;
import model.User;
import service.OperationItemService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ADMINUserChangeServlet",urlPatterns = "/adminuser_change")
public class ADMINUserChangeServlet extends HttpServlet {
    private OperationItemService opiService=new OperationItemService();
    private UserService uService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user= new User();
        int id=Integer.parseInt(request.getParameter("id"));
        User user1=uService.selectByID(id);
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());
        String order_id=request.getParameter("id");
        opitem.setOperation("销售人员管理-管理员"+user.getId()+"打算对销售人员"+id+"进行登录口令更改");

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
        request.getSession().setAttribute("user1",user1);
        request.getRequestDispatcher("admin_user_change.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
