package servlet;

import model.AdminBigdata;
import model.UserBigdata;
import service.AdminBigDataService;
import service.UserBigDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@WebServlet(name = "ExitServlet",urlPatterns = "/exit")
public class ExitServlet extends HttpServlet {
    private UserBigDataService ubdService=new UserBigDataService();
    private AdminBigDataService abdService=new AdminBigDataService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        UserBigdata ubd=new UserBigdata();
        ubd=(UserBigdata)request.getSession().getAttribute("ubd");

        if(ubd!=null)
        {
//            System.out.println("user");
            ubd.setExit_datetime(new Date());
            // 将 Date 对象转换为 Instant 对象
            Instant instant1 = ubd.getLog_datetime().toInstant();
            Instant instant2 = ubd.getExit_datetime().toInstant();
            // 计算时间间隔
            Duration duration = Duration.between(instant1, instant2);

            // 将时间间隔转换为秒数
            int seconds = (int)duration.getSeconds();

            ubd.setStaytime(seconds);
//            System.out.println(ubd);
            try {
                ubdService.addUbd(ubd);
                request.getSession().removeAttribute("ubd");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        else
        {
//            System.out.println("abd");

            AdminBigdata abd=null;
            abd=(AdminBigdata)request.getSession().getAttribute("abd");

            abd.setExit_datetime(new Date());
//            System.out.println(abd);
            abdService.addAbd(abd);

            request.getSession().removeAttribute("abd");

        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
