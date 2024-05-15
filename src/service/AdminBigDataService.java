package service;

import dao.AdminBigDataDao;
import model.AdminBigdata;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminBigDataService {
    private AdminBigDataDao abdDao=new AdminBigDataDao();

    public void addAbd(AdminBigdata abd) {
        Connection con = null;
        try {

            con = DBUtil.getConnection();

//            con.setAutoCommit(false);
//            System.out.println(ubd);
            abdDao.insertAdminBigData(con, abd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
