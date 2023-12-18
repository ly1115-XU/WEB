package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserChangePwdServlet",urlPatterns = "/user_changepwd")
public class UserChangePwdServlet extends HttpServlet {
    private UserService uService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password=request.getParameter("password");
        String newPwd=request.getParameter("newPassword");
        String newPwdagain=request.getParameter("newPasswordagain");
        User u=(User)request.getSession().getAttribute("user");
        if(password.equals(u.getPassword())){
            if(newPwd.equals(newPwdagain))
            {
                u.setPassword(newPwd);
                uService.updatePwd(u);
                request.setAttribute("msg","修改成功");
                request.getRequestDispatcher("/user_center.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("failMsg","新密码两次输入不一致，请检查后重新输入！");
                request.getRequestDispatcher("user_center.jsp").forward(request,response);
            }

        }
        else{
            request.setAttribute("failMsg","修改失败，原密码错误！请重试！");
            request.getRequestDispatcher("user_center.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
