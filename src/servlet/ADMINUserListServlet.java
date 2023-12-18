package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ADMINUserListServlet",urlPatterns = "/adminuser_list")
public class ADMINUserListServlet extends HttpServlet {
    private UserService uService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int pageNumber = 1;
//        if(request.getParameter("pageNumber")!=null)
//        {
//            pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
//        }
        List<User> list=null;
        try {
            list=uService.getUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getSession().setAttribute("list",list);
        request.getRequestDispatcher("admin_user_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
