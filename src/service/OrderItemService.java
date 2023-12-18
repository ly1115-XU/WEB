package service;

import dao.OrderItemDao;
import model.OrderItem;
import model.Sold;

import java.sql.SQLException;
import java.util.List;

public class OrderItemService {
    private OrderItemDao oiDao=new OrderItemDao();
//    int typeid=0;
    public List<Sold> getOrderItemListByID(int typeid) throws SQLException {
        List<Sold>list=null;
        list=oiDao.getOrderItemByTypeID(typeid);
//        System.out.println(list);
        return list;
    }

    public double gettotalamount(int typeid) throws SQLException {
        double total=(double)oiDao.getTotalAmount(typeid);
        return total;
    }

    public int getGoodsid(int id) throws SQLException {
        int goodsid=oiDao.getGoodIdById(id);
        return goodsid;
    }

    public int getOrderid(int id) throws SQLException {
        int orderid=oiDao.getOrderIdById(id);
        return orderid;
    }
}
