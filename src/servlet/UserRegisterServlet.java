package servlet;

import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //拿到前台数据，封装

        User user=new User();

        //request.getParameterMap()可以获取多个参数

        try {
            BeanUtils.copyProperties(user,request.getParameterMap());//自动进行封装
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println("有进行这一步");
        //调用业务层，判断
        UserService uService = new UserService();
        if(uService.register(user)){
            request.setAttribute("msg","恭喜您注册成功，请登录");
            request.getRequestDispatcher("user_login.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户名或邮箱已被注册，请尝试其他用户名或邮箱");
            request.getRequestDispatcher("user_register.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
