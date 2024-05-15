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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CloseServlet",urlPatterns = "/CloseServlet")
public class CloseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    private OperationItemService opiService=new OperationItemService();
    private AdminBigDataService abdService=new AdminBigDataService();
    private UserBigDataService ubdService=new UserBigDataService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminBigdata abd=null;
        UserBigdata ubd=null;
        abd=(AdminBigdata)request.getSession().getAttribute("abd");
        ubd=(UserBigdata)request.getSession().getAttribute("ubd");
//        System.out.println(abd);
//        System.out.println(ubd);
//        System.out.println(1);
        if(abd!=null)
        {
            abd.setExit_datetime(new Date());
            abdService.addAbd(abd);
        }
        else if(ubd!=null)
        {
            ubd.setExit_datetime(new Date());
            try {
                ubdService.addUbd(ubd);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        // 处理跳转逻辑
        // 在这里可以执行你需要的逻辑操作

        response.setContentType("text/plain");
//        response.getWriter().println("Redirected to YourServlet");
    }

    // 解析 JSON 数据，提取退出时间
    private Date extractLogoutTime(String jsonData) {

        String logoutTimeString = jsonData.contains("logoutTime") ? jsonData.substring(jsonData.indexOf("logoutTime") + 13, jsonData.indexOf("}") - 1) : null;

        // 使用 SimpleDateFormat 将时间字符串解析为 Date 对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date logoutTime = null;
        try {
            logoutTime = dateFormat.parse(logoutTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return logoutTime;
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
