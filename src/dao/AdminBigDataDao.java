package dao;

import model.AdminBigdata;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminBigDataDao {
    public void insertAdminBigData(Connection con, AdminBigdata abd) {
        try {
//            System.out.println(ubd);
            QueryRunner r = new QueryRunner();
            String sql = "insert into admin_bigdata(log_datetime,exit_datetime,ip_address,user_id) values(?,?,?,?)";
            r.update(con, sql, abd.getLog_datetime(), abd.getExit_datetime(), abd.getIp_address(),
                     abd.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
