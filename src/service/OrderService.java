package service;

import dao.GoodsDao;
import dao.OrderDao;
import model.Goods;
import model.Order;
import model.OrderItem;
import model.Page;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDao oDao=new OrderDao();
    private GoodsDao gDao=new GoodsDao();
    public void addOrder(Order order){
//        System.out.println(order);
        Connection con=null;
        try {
            con= DBUtil.getConnection();
            con.setAutoCommit(false);
            oDao.insertOrder(con,order);
            int id=oDao.getLastInsertId(con);
            order.setId(id);
//            System.out.println(order.getItemMap().values());
            for(OrderItem item:order.getItemMap().values()){
//                System.out.println(item.getGoods());
                Goods g=item.getGoods();
//                Goods g=gDao.getGoodsByName(item.getGoodsName());
//                System.out.println(g);
//                System.out.println(g.getType());
                int typeid=g.getType().getId();
//                System.out.println(typeid);
                oDao.insertOrderItem(con,item,typeid);
                con.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if(con!=null){
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public List<Order>selectAll(int userid){
        List<Order>list=null;
        try {
            list=oDao.selectAll(userid);
            for(Order o:list){
                List<OrderItem> l=oDao.selectAllItem(o.getId());
                o.setItemList(l);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
//    public Page getOrderPage(int status, int pageNumber){
//        Page p=new Page();
//        p.setPageNumber(pageNumber);
//        int pageSize=10;
//        int totalCount=0;
//        try {
//            totalCount=oDao.getOrderCount(status);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        p.SetPageSizeAndTotalCount(pageSize,totalCount);
//        List list=null;
//        try {
//            list=oDao.selectOrderList(status,pageNumber,pageSize);
//            for(Order o:(List<Order>)list){
//                List<OrderItem>l=oDao.selectAllItem(o.getId());
//                o.setItemList(l);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        p.setList(list);
//        return p;
//    }
    public List<Order> getOrder(int status)
    {
        List<Order>list=null;
        try {
            list=oDao.selectOrderList(status);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    public void updateStatus(int id,int status){
        try {
            oDao.updateStatus(id,status);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void delete(int id){
        Connection con = null;
        try {
            con=DBUtil.getDataSource().getConnection();
            con.setAutoCommit(false);
            oDao.deleteOrderItem(con,id);
            oDao.deleteOrder(con,id);
            con.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if(con!=null){
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Order getOrderById(int orderid) throws SQLException {

        Order order=oDao.getOrder(orderid);
        return order;
    }
}
