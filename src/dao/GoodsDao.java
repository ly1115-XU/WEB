package dao;

import model.Goods;
import model.Recommend;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import utils.DBUtil;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.*;

public class GoodsDao {
    public List<Map<String,Object>>getGoodsList(int recommendType) throws SQLException {//得到推荐商品的id,name,cover,price ,name typename
        //拿到执行者对象
        QueryRunner r =new QueryRunner(DBUtil.getDataSource());
        //sql
        String sql="select g.id,g.name,g.cover,g.price,t.name typename from recommend r,goods g,type t where type=? and r.goods_id=g.id and g.type_id=t.id";
        //执行sql
        return r.query(sql,new MapListHandler(),recommendType);
    }
    public List<Map<String,Object>>getScorllGood() throws SQLException {
        //拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        //sql
        String sql="select g.id,g.name,g.cover,g.price from recommend r,goods g where type = 1 and r.goods_id=g.id";
        //执行sql
        return r.query(sql,new MapListHandler());

    }
//    public List<Goods>selectGoodsByTypeID(int typeID,int pageNumber, int pageSize) throws SQLException {
//        //拿到执行者对象
//        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        //sql
//        if(typeID==0)
//        {
//            String sql="select * from goods limit ? , ?";
//            //执行
//            return  r.query(sql,new BeanListHandler<Goods>(Goods.class),(pageNumber-1)*pageSize,pageSize);
//        }
//        else
//        {
//            String sql="select * from goods where type_id = ? limit ? , ?";
//            return r.query(sql,new BeanListHandler<Goods>(Goods.class),typeID,(pageNumber-1)*pageSize,pageSize);
//        }
////        else
////        {
////            String sql="select distinct goo from orderitem";
////            List<Integer>goodsidlist=(List<Integer>) r.query(sql, new ColumnListHandler("goods_id"));
////            List<Integer> goodsidlist = r.query(sql, new ResultSetHandler<Integer>());
//
////            List<Goods>list=null;
////            for(int i=(pageNumber-1)*pageSize,j=0;i<goodsidlist.size()&&j<pageSize;i++,j++)
////            {
////                list.add(this.getGoodsById(goodsidlist.get(i)));
////            }
////            return list;
////        }
//    }
public List<Goods>selectGoodsByTypeID(int typeID) throws SQLException {
    //拿到执行者对象
    QueryRunner r = new QueryRunner(DBUtil.getDataSource());
    //sql
    if (typeID == 0) {
        String sql = "select * from goods";
        //执行
        return r.query(sql, new BeanListHandler<Goods>(Goods.class));
    }
    else
    {
        String sql="select * from goods where type_id = ?";
            return r.query(sql,new BeanListHandler<Goods>(Goods.class),typeID);
    }
}
    public int getCountOfGoodsByTypeID(int typeID) throws SQLException {
        //拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        //sql 并且执行
        if(typeID==0)
        {
            String sql="select count(*) from goods";
            return ((Long)r.query(sql,new ScalarHandler())).intValue();
        }
        else
        {
            String sql="select count(*) from goods where type_id=?";
//            System.out.println(((Long)r.query(sql,new ScalarHandler(),typeID)).intValue());
            return ((Long)r.query(sql,new ScalarHandler(),typeID)).intValue();
//            r.query(sql,new ScalarHandler(),)
        }
//        else
//        {
////            SELECT COUNT(DISTINCT goods_id) AS num_goods_id FROM orderitem;
//
//            String sql="select count(distinct goods_id) from orderitem";
////            System.out.println(((Long)r.query(sql,new ScalarHandler())).intValue());
//            return ((Long)r.query(sql,new ScalarHandler())).intValue();
//        }
    }
    public List<Goods>selectGoodsbyRecommend(int type,int pageNumber,int pageSize) throws SQLException {
        //拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        if(type==0){
            //当不添加推荐类型限制的时候
            String sql="select g.id,g.name,g.cover,g.image1,g.image2,g.intro,g.price,g.stock,t.name,typename from goods g,type t where g.type_id=t.id order by g.id limit ?,?";
            return r.query(sql,new BeanListHandler<Goods>(Goods.class),(pageNumber-1)*pageSize,pageSize);
        }
        String sql = " select g.id,g.name,g.cover,g.image1,g.image2,g.intro,g.price,g.stock,t.name typename from goods g,recommend r,type t where g.id=r.goods_id and g.type_id=t.id and r.type=? order by g.id limit ?,?";
        return r.query(sql, new BeanListHandler<Goods>(Goods.class),type,(pageNumber-1)*pageSize,pageSize);
    }
    public int getRecommendCountOfGoodsByTypeID(int type) throws SQLException {
        if(type==0)return getCountOfGoodsByTypeID(0);
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from recommend where type=?";
        return ((Long)r.query(sql, new ScalarHandler(),type)).intValue();
    }
    public Goods getGoodsById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        String sql = "select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.id = ? and g.type_id=t.id";
        String sql = "select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.id = ? and g.type_id=t.id";
        return r.query(sql, new BeanHandler<Goods>(Goods.class),id);
    }

    public int getSearchCount(String keyword) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from goods where name like ?";
        return ((Long)r.query(sql, new ScalarHandler(),"%"+keyword+"%")).intValue();
    }
    public List<Goods> selectSearchGoods(String keyword, int pageNumber, int pageSize) throws SQLException{
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from goods where name like ? limit ?,?";
        return r.query(sql, new BeanListHandler<Goods>(Goods.class),"%"+keyword+"%",(pageNumber-1)*pageSize,pageSize);
    }
    public boolean isScroll(Goods g) throws SQLException {
        return isRecommend(g, 1);
    }
    public boolean isHot(Goods g) throws SQLException {
        return isRecommend(g, 2);
    }
    public boolean isNew(Goods g) throws SQLException {
        return isRecommend(g, 3);
    }
    private boolean isRecommend(Goods g,int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from recommend where type=? and goods_id=?";
        Recommend recommend = r.query(sql, new BeanHandler<Recommend>(Recommend.class),type,g.getId());
        if(recommend==null) {
            return false;
        }else {
            return true;
        }
    }
    public void addRecommend(int id,int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into recommend(type,goods_id) values(?,?)";
        r.update(sql,type,id);
    }
    public void removeRecommend(int id,int type) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from recommend where type=? and goods_id=?";
        r.update(sql,type,id);
    }
    public void insert(Goods g) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into goods(name,cover,image1,image2,price,intro,stock,type_id) values(?,?,?,?,?,?,?,?)";
        r.update(sql,g.getName(),g.getCover(),g.getImage1(),g.getImage2(),g.getPrice(),g.getIntro(),g.getStock(),g.getType().getId());
    }
    public void update(Goods g) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update goods set name=?,cover=?,image1=?,image2=?,price=?,intro=?,stock=?,type_id=? where id=?";
        r.update(sql,g.getName(),g.getCover(),g.getImage1(),g.getImage2(),g.getPrice(),g.getIntro(),g.getStock(),g.getType().getId(),g.getId());
    }
    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from goods where id = ?";
        r.update(sql,id);
    }

    public Goods getGoodsByName(String goodsName) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        String sql = "select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.id = ? and g.type_id=t.id";
        String sql = "select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.name = ? and g.type_id=t.id";
        return r.query(sql, new BeanHandler<Goods>(Goods.class),goodsName);
    }
}

