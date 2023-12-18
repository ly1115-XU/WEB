package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_login")
public class UserLoginServlet extends HttpServlet {
    private UserService uService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数，调用业务层
        String ue=request.getParameter("ue");
        String password = request.getParameter("password");

        //调用业务层，login=>user
        User user=uService.login(ue,password);
        //给出响应
        if(user==null)
        {//失败
            request.setAttribute("failMsg","用户名/邮箱或者密码错误，请重新登录");
            request.getRequestDispatcher("/user_login.jsp").forward(request,response);
        }
        else {

            //成功
            request.getSession().setAttribute("user",user);
//            if(request.getSession().getAttribute("failMsg").equals("请登录后，再提交订单")){
//                request.getRequestDispatcher("/order_sumbit.jsp").forward(request,response);
//            }
            if(user.isIsadmin())
            {
                request.getRequestDispatcher("/index1.jsp").forward(request,response);
            }

            request.getRequestDispatcher("/user_center.jsp").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
