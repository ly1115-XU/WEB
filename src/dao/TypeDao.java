package dao;

import model.Type;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class TypeDao {
    //查询所有的分类
    public List<Type>getAllType() throws SQLException {
        //拿到执行者
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        //sql并且执行
        String sql="select * from type";
        //执行sql 返回数据
//        System.out.println(new BeanListHandler<Type>(Type.class));

        return r.query(sql,new BeanListHandler<Type>(Type.class));

    }
    public Type selectTypeNameByID(int typeid) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select * from type where id=?";
        return r.query(sql,new BeanHandler<Type>(Type.class),typeid);
    }
    public Type select(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from type where id = ?";
        return r.query(sql, new BeanHandler<Type>(Type.class),id);
    }
    public void insert(Type t) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "insert into type(name) values(?)";
        r.update(sql,t.getName());
    }
    public void update(Type t) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "update type set name=? where id = ?";
        r.update(sql,t.getName(),t.getId());
    }
    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from type where id = ?";
        r.update(sql,id);
    }

    public Type selectTypeByGoodsID(int goodsid) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select type.* from type,goods where goods.type_id=type.id and goods.id=?";
        return r.query(sql,new BeanHandler<Type>(Type.class),goodsid);

    }

    public String getTypeNameByID(int typeid) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select name from type where id=?";
        return (String)r.query(sql,new ScalarHandler(),typeid);
    }
}
