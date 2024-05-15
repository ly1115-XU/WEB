package servlet;

import model.Order;
import model.User;
import model.UserBigdata;
import org.apache.commons.beanutils.BeanUtils;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet(urlPatterns = "/order_confirm")
public class OrderConfirmServlet extends HttpServlet {
    private OrderService oService=new OrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order o=(Order)request.getSession().getAttribute("order");
        UserBigdata ubd=(UserBigdata)request.getSession().getAttribute("ubd");
//        System.out.println(o.getAddress()+" "+o.getName());
        try {
            BeanUtils.copyProperties(o,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        o.setDatetime(new Date());
        o.setStatus(2);
        o.setUser((User) request.getSession().getAttribute("user"));
//        System.out.println(o);
//        System.out.println(o.getItemMap());
//        System.out.println(o.getItemList());

        oService.addOrder(o);
//        ubd.setOreder_id(o.getId());
        request.getSession().removeAttribute("order");

        request.setAttribute("msg","订单支付成功！");
        request.getRequestDispatcher("/order_success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
