package dao;

import model.Goods;
import model.Type;
import model.View;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewDao {
    public void addView(View view){
        //拿到执行对象
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        //sql
        String sql="insert into view(goodsid,typeid,amount) values(?,?,?)";
//        System.out.println(view.getGoodsId()+" "+view.getTypeId());
        //执行
        try {
            r.update(sql,view.getGoodsId(),view.getTypeId(),view.getAmount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    public boolean selectByGoodsid(int goodsid) throws SQLException {
//        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
//        String sql="select v.id g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename,v.amount from view v,goods g,type t where goodsid=?";
////        g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.id = ? and g.type_id=t.id
//        View view = null;
//        view = r.query(sql,new BeanHandler<View>(View.class),goodsid);
//
//        if(view==null){
//            return false;
//        } else{
//            return true;
//        }
//    }
public boolean selectByGoodsid(int goodsid) throws SQLException {
    QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//    String sql = "SELECT v.id AS id,g.id AS gid g.name AS name, g.cover AS cover, g.image1 AS image1, " +
//            "g.image2 AS image2, g.price AS price, g.intro AS intro, g.stock AS stock, " +
//            "t.id AS typeid, t.name AS typename, v.amount AS amount " +
//            "FROM view v, goods g, type t " +
//            "WHERE goodsid = ? AND gid=goodid AND g.type_id=t.id";
    String sql="SELECT * FROM view WHERE goodsid=?";

    View view = r.query(sql, new BeanHandler<>(View.class), goodsid);
    return view != null;
}


    public void updateView(View view){
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="update view set amount = amount + 1 where goodsid=?";
        try {
            r.update(sql,view.getGoodsId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//     public List<View> selectByTypeid(int typeid) throws SQLException {
//        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
//        String sql="select id,goodsid,typeid,amount from view where typeid=?";
////
//        return r.query(sql, new BeanListHandler<View>(View.class),typeid);
//     }

    public List<View> selectByTypeid(int typeid) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "SELECT v.id, v.goodsid, v.typeid, v.amount, g.id AS goods_id, g.name AS goods_name, " +
                "g.cover AS goods_cover, g.image1 AS goods_image1, g.image2 AS goods_image2, g.price AS goods_price," +
                " g.intro AS goods_intro, g.stock AS goods_stock, t.id AS type_id, t.name AS type_name " +
                "FROM view v " +
                "INNER JOIN goods g ON v.goodsid = g.id " +
                "INNER JOIN type t ON v.typeid = t.id " +
                "WHERE v.typeid = ?";

        ResultSetHandler<List<View>> h = rs -> {
            List<View> views = new ArrayList<>();
            while (rs.next()) {
                View view = new View();
                view.setId(rs.getInt("id"));
                view.setAmount(rs.getInt("amount"));

                Goods goods = new Goods();
                goods.setId(rs.getInt("goods_id"));
                goods.setName(rs.getString("goods_name"));
                goods.setCover(rs.getString("goods_cover"));
                goods.setImage1(rs.getString("goods_image1"));
                goods.setImage2(rs.getString("goods_image2"));
                goods.setPrice(rs.getFloat("goods_price"));
                goods.setIntro(rs.getString("goods_intro"));
                goods.setStock(rs.getInt("goods_stock"));

                Type type = new Type();
                type.setId(rs.getInt("type_id"));
                type.setName(rs.getString("type_name"));
                view.setType(type);

                goods.setType(type);
                view.setGoods(goods);



                views.add(view);
            }
            return views;
        };

        return r.query(sql, h, typeid);
    }


    public int selectAmountByGoodsid(int goodsid) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select amount from view where goodsid=?";

         return ((Integer)r.query(sql, new ScalarHandler(), goodsid)).intValue();
     }

    public List getGoodsid() throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select goodsid from view order by amount desc ";
//        return r.query(sql,List<  >);
        return r.query(sql,new ColumnListHandler());
//        List<String> results = r.query(sql, new ColumnListHandler<String>());

    }
}
