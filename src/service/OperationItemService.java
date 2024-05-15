package service;

import dao.OperationItemDao;
import model.OperationItem;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class OperationItemService {
    private OperationItemDao opiDao=new OperationItemDao();
    public void addOperationItem(OperationItem opitem) {
        Connection con=null;
        try {

            con = DBUtil.getConnection();

            opiDao.insertOperationItem(con, opitem);
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
