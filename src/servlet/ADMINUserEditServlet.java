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
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "ADMINUserEditServlet",urlPatterns = "/adminuser_edit")
public class ADMINUserEditServlet extends HttpServlet {
    private UserService uService=new UserService();
    private OperationItemService opiService=new OperationItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User u=new User();
//        try {
//            BeanUtils.copyProperties(u,request.getParameterMap());//自动进行封装
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        u.setId();
        User u=(User)request.getSession().getAttribute("user1");
        OperationItem opitem=new OperationItem();
        if(u==null)
        {
            System.out.println("用户为空");
        }
        if(request.getParameter("username")!=null)
        {
            u.setUsername(request.getParameter("username"));
        }

        if(request.getParameter("email")!=null)
        {
            u.setEmail(request.getParameter("email"));
        }

        if(request.getParameter("password")!=null)
        {
            u.setPassword(request.getParameter("password"));
        }
//        opitem.setOperation("销售人员管理-添加了销售人员"+user.getUsername());
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());
        String param=null;
        param=request.getParameter("status");

        opitem.setOperation("销售人员管理-管理员"+user.getId()+"更改了销售人员"+user.getUsername()+"的登录口令");

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
        try {
            uService.updateUser(u);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/adminuser_list").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
