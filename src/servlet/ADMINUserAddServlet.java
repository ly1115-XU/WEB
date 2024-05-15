package servlet;

import model.OperationItem;
import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.OperationItemService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet(name = "ADMINUserAddServlet",urlPatterns = "/adminuser_add")
public class ADMINUserAddServlet extends HttpServlet {
    UserService uService=new UserService();
    OperationItemService opiService= new OperationItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        OperationItem opitem=new OperationItem();
//        user=request.getParameterMap();
        try {
            BeanUtils.copyProperties(user,request.getParameterMap());//自动进行封装
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        int a=1;
        user.setIsadmin(true);

        uService.register(user);
        opitem.setOp_datetime(new Date());
        User user1=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user1.getId());

        String order_id=request.getParameter("id");
        opitem.setOperation("销售人员管理-管理员"+user1.getId()+"添加了销售人员"+user.getId());

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
        request.getRequestDispatcher("/adminuser_list").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
