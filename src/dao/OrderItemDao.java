package dao;

import model.OrderItem;
import model.Sold;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderItemDao {
    public List<Sold> getOrderItemByTypeID(int typeid) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        if(typeid==0)
        {
//            String sql="select orderitem.id,orderitem.price,orderitem.amount,goods.name as goodsName goods.id,goods.name,goods.cover,goods.image1,goods.intro," +
//                    "goods.image2,goods.price,goods.stock,goods.type,goods.isScroll,goods.isHot,goods.isNew from orderitem,goods,type,orders" +
//                    "where orderitem.goods_id=goods.id and type.id=orderitem.type_id and goods.id=orderitem.goods_id and orders.id=orderitem.order_id";
//            String sql="select orderitem.id,orderitem.price,orderitem.amount,goods.name as goodsName from orderitem,goods where orderitem.goods_id=goods.id ";
            String sql="select oi.id,oi.price,oi.amount,oi.goods_id,oi.order_id,oi.type_id from orderitem oi";
//            System.out.println("111");
//            System.out.println(r.query(sql, new BeanListHandler<Sold>(Sold.class)));
            return r.query(sql, new BeanListHandler<Sold>(Sold.class));
        }
        else
        {
//            String sql="select orderitem.id,orderitem.price,orderitem.amount,goods.name as goodsName from orderitem,goods,type where orderitem.goods_id=goods.id type_id=?";
            String sql="select * from orderitem where type_id=?";
            return r.query(sql, new BeanListHandler<Sold>(Sold.class),typeid);
        }

    }

    public int getTotalAmount(int typeid) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        if(typeid==0)
        {
            String sql="select sum(amount) from orderitem";
            return ((Long)(r.query(sql,new ScalarHandler()))).intValue();
        }
        else
        {
            String sql="select sum(amount) from orderitem where type_id=? ";
            return ((Long)(r.query(sql,new ScalarHandler(),typeid))).intValue();
        }
    }

    public int getGoodIdById(int id) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select goods_id from orderitem where orderitem.id=?";
        return (int)(r.query(sql,new ScalarHandler(),id));
    }

    public int getOrderIdById(int id) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select order_id from orderitem where orderitem.id=?";
        return (int)(r.query(sql,new ScalarHandler(),id));
    }
}
