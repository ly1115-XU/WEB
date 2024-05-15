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

@WebServlet(name = "ADMINUserDeleteServlet",urlPatterns = "/adminuser_delete")
public class ADMINUserDeleteServlet extends HttpServlet {
    private UserService uService= new UserService();
    private OperationItemService opiService=new OperationItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
//        User user=uService.selectByID(id);
        boolean is=uService.delete(id);
        OperationItem opitem=new OperationItem();
        opitem.setOp_datetime(new Date());
        User user=(User)request.getSession().getAttribute("user");
        opitem.setUser_id(user.getId());

        if(is)
        {
            request.setAttribute("msg","删除用户成功");
            opitem.setOperation("销售人员管理-管理员"+user.getId()+"删除了销售人员"+id);
        }
        else {
            request.setAttribute("failMsg","删除用户失败，请重试！");
            opitem.setOperation("销售人员管理-管理员"+user.getId()+"对销售人员"+id+"进行了删除操作，但未成功");
        }
//        opitem.setOperation("删除了订单"+id);

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
//        request.getRequestDispatcher("admin_user_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
