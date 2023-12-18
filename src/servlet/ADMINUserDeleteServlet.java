package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ADMINUserDeleteServlet",urlPatterns = "/adminuser_delete")
public class ADMINUserDeleteServlet extends HttpServlet {
    private UserService uService= new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
//        User user=uService.selectByID(id);
        boolean is=uService.delete(id);
        if(is)
        {
            request.setAttribute("msg","删除用户成功");
        }
        else {
            request.setAttribute("failMsg","删除用户失败，请重试！");
        }
        request.getRequestDispatcher("admin_user_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
