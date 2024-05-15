package service;

import dao.GoodsDao;
import dao.UserBigDataDao;
import model.UserBigdata;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class UserBigDataService {
    private GoodsDao gDao = new GoodsDao();
    private UserBigDataDao ubdDao = new UserBigDataDao();

    public void addUbd(UserBigdata ubd) throws SQLException {
        Connection con = null;
        try {

            con = DBUtil.getConnection();

//            con.setAutoCommit(false);
//            System.out.println(ubd);
            ubdDao.insertUserBigData(con, ubd);
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

    public Date getEarlyDateByUserId(int id) throws SQLException {
        return ubdDao.getEarlyDateByUserId(id);
    }

    public int getCountByUser(int id) throws SQLException {
        return ubdDao.getCountByUser(id);
    }
}
