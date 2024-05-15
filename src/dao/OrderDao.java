package dao;

import model.Order;
import model.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    public void insertOrder(Connection con, Order order) throws SQLException {
        //执行器
        QueryRunner r = new QueryRunner();
        String sql="insert into orders(total,amount,status,paytype,name,phone,address,datetime,user_id) value(?,?,?,?,?,?,?,?,?)";
        r.update(con,sql,order.getTotal(),order.getAmount(),order.getStatus(),order.getPaytype(),order.getName(),
                order.getPhone(),order.getAddress(),order.getDatetime(),order.getUser().getId());
    }
    public int getLastInsertId(Connection con) throws SQLException {
        QueryRunner r = new QueryRunner();
        String sql="select last_insert_id()";
        BigInteger bi=(BigInteger)(r.query(con,sql,new ScalarHandler()));
        return Integer.parseInt(bi.toString());
    }
    public void insertOrderItem(Connection con, OrderItem item,int typeid) throws SQLException {
//        System.out.println("插入订单项");
        QueryRunner r = new QueryRunner();
        String sql="insert into orderitem(price,amount,goods_id,order_id,type_id) value(?,?,?,?,?)";
        r.update(con,sql,item.getPrice(),item.getAmount(),item.getGoods().getId(),item.getOrder().getId(),typeid);
    }
    public List<Order>selectAll(int userid) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="select* from orders where user_id=? order by datetime desc";
        return r.query(sql,new BeanListHandler<Order>(Order.class),userid);
    }
    public List<OrderItem>selectAllItem(int orderid) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="select i.id,i.price,i.amount,g.name as goodsName from orderitem i" +
                ",goods g where order_id=? and i.goods_id=g.id";
        return r.query(sql,new BeanListHandler<OrderItem>(OrderItem.class),orderid);
    }
    public int getOrderCount(int status) throws SQLException {
        QueryRunner r = new QueryRunner();
        String sql="";
        if(status==0){
            sql="select count(*) from orders";
            return ((Long)(r.query(sql,new ScalarHandler()))).intValue();
        }
        else{
            sql="select count(*) from orders where status=?";
            return (int)((long)r.query(sql,new ScalarHandler(),status));
        }
    }
//    public List<Order>selectOrderList(int status,int pageNumber,int pageSize) throws SQLException {
//        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        if(status==0){
//            String sql="select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from orders o,user u where o.user_id=u.id order by o.datetime desc limit ?,?";
//            return r.query(sql,new BeanListHandler<Order>(Order.class),(pageNumber-1)*pageSize,pageSize);
//        }
//        else{
//            String sql="select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from orders o,user u where o.user_id=u.id and o.status=? order by o.datetime desc limit ?,?";
//            return r.query(sql,new BeanListHandler<Order>(Order.class),status,(pageNumber-1)*pageSize,pageSize);
//        }
//    }
    public List<Order>selectOrderList(int status) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        if(status==0)
        {
            String sql="select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from orders o,user u where o.user_id=u.id order by o.datetime desc";
            return r.query(sql,new BeanListHandler<Order>(Order.class));
        }
        else
        {
            String sql="select o.id,o.total,o.amount,o.status,o.paytype,o.name,o.phone,o.address,o.datetime,u.username from orders o,user u where o.user_id=u.id and o.status=? order by o.datetime desc";
            return r.query(sql,new BeanListHandler<Order>(Order.class),status);
        }
    }
    public void updateStatus(int id,int status) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="update orders set status=? where id=?";
        r.update(sql,status,id);
    }
    public void deleteOrder(Connection con,int id) throws SQLException {
        QueryRunner r = new QueryRunner();
        String sql="delete from orders where id=?";
        r.update(con,sql,id);
    }
    public void deleteOrderItem(Connection con,int id) throws SQLException {
        QueryRunner r = new QueryRunner();
        String sql="delete from orderitem where order_id=?";
        r.update(con,sql,id);
    }

    public Order getOrder(int orderid) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="select * from orders where orders.id=?";
//        return r.query(sql,new ScalarHandler(),orderid);
        return r.query(sql,new BeanHandler<Order>(Order.class),orderid);
    }

    public double getCostByUserId(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select sum(total) from orders where user_id=?";
        Number result = (Number)r.query(sql, new ScalarHandler(), id);

        // 如果结果为null，则返回0.0
        return result != null ? result.doubleValue() : 0.0;
    }


}
