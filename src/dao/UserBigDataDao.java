package dao;

import model.UserBigdata;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class UserBigDataDao {
    public void insertUserBigData(Connection con,UserBigdata ubd) {
        try {
//            System.out.println(ubd);
            QueryRunner r = new QueryRunner();
            String sql = "insert into user_bigdata(log_datetime,exit_datetime,ip_address,staytime,user_id) values(?,?,?,?,?)";
            r.update(con, sql, ubd.getLog_datetime(), ubd.getExit_datetime(), ubd.getIp_address(),
                    ubd.getStaytime(), ubd.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Date getEarlyDateByUserId(int id) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select MIN(log_datetime) from user_bigdata where user_id=?";
        return (Date)r.query(sql,new ScalarHandler(),id);
    }

    public int getCountByUser(int id) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select COUNT(*) from user_bigdata where user_id=?";
        return ((Number)r.query(sql,new ScalarHandler(),id)).intValue();
    }

}
