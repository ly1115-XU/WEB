package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogOffServlet",urlPatterns = "/log_off")
public class LogOffServlet extends HttpServlet {
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= (User)request.getSession().getAttribute("user");
//        System.out.println(111);
//        System.out.println(user.getId());
        String logoff="null";
        if(userService.delete(user.getId()))
        {
//            logoff="success";
            request.setAttribute("msg","注销成功!");
        }
//        System.out.println(222);
        request.getSession().removeAttribute("user");

//        request.getSession().setAttribute("logoff",logoff);
//        System.out.println(333);
//        request.getRequestDispatcher("user_center.jsp");
//        response.getWriter().print("ok");
        request.getRequestDispatcher("/user_login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
