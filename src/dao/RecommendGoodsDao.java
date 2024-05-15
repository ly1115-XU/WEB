package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import utils.DBUtil;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class RecommendGoodsDao {
//    public static DataSource getDataSource() throws SQLException, PropertyVetoException {
//        // 使用 c3p0 数据库连接池获取 DataSource
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/web");
//        dataSource.setUser("root");
//        dataSource.setPassword("001128yyqx");
//        return dataSource;
//    }


    private MySQLJDBCDataModel dataModel = null; // 声明 dataModel 对象

    public MySQLJDBCDataModel getdataModel() throws SQLException, PropertyVetoException {
        if (dataModel == null) {
            // 如果 dataModel 对象还没有初始化，则通过获取 DataSource 对象来初始化它
            DataSource dataSource = DBUtil.getDataSource(); // 假设有一个方法能够获取 DataSource
            dataModel = new MySQLJDBCDataModel(dataSource, "recommend", "user_id", "goods_id", "preference",null);
        }
        return dataModel;
    }

    public float getpreference(int user_id,int goods_id) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
//        System.out.println(user_id);
//        System.out.println(goods_id);
        String sql="select preference from recommend where user_id=? and goods_id=?";
        return (float)r.query(sql,new ScalarHandler(),user_id,goods_id);
    }

    public void updateViewPer(int user_id,int goods_id) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="update recommend set preference=? where user_id=? and goods_id=?";
        r.update(sql,getpreference(user_id, goods_id)+0.5,user_id,goods_id);
    }

    public void updateBuyPre(int user_id, int goods_id) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="update recommend set preference=? where user_id=? and goods_id=?";
        r.update(sql,getpreference(user_id, goods_id)+1.0,user_id,goods_id);
    }

    public void addUser(int user_id,int goods_id) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
//        System.out.println(user_id);
        String sql = "insert into recommend(user_id,goods_id,preference) values(?,?,?)";
        r.update(sql,user_id,goods_id,0.0);
    }
}
