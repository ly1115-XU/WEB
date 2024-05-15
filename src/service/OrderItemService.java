package service;

import dao.OrderItemDao;
import model.GoodsSale;
import model.Sold;

import java.sql.SQLException;
import java.util.List;

public class OrderItemService {
    private OrderItemDao oiDao=new OrderItemDao();
//    int typeid=0;
    public List<Sold> getOrderItemListByID(int typeid) throws SQLException {
        List<Sold>list=null;
        list=oiDao.getOrderItemByID(typeid);
//        System.out.println(list);
        return list;
    }

    public int gettotalamount(int typeid) throws SQLException {
        int total=(int)oiDao.getTotalAmount(typeid);
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

//    public List<OrderItem>getOrderItemList(int typeid)
    public List<GoodsSale> getOrderItemListByTypeID(int typeid) throws SQLException {
        List<GoodsSale>gsList=null;
        gsList=oiDao.getOrderItemByTypeID(typeid);
        return gsList;
    }
//    getOrderItemByTypeIDStats
    public List<GoodsSale> getOrderItemByTypeIDStats(int typeid) throws SQLException {
        List<GoodsSale>gsList=null;
        gsList=oiDao.getOrderItemByTypeIDStats(typeid);
        return gsList;
    }
}
