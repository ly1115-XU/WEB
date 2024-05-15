package service;

import dao.GoodsDao;
import dao.RecommendGoodsDao;
import dao.UserDao;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

public class RecommendGoodsService {
    private RecommendGoodsDao rgDao=new RecommendGoodsDao();
    private GoodsDao gDao=new GoodsDao();
    private UserDao uDao=new UserDao();
    private MySQLJDBCDataModel dataModel;
    public MySQLJDBCDataModel getdataModel() throws SQLException, PropertyVetoException {
        dataModel=rgDao.getdataModel();
        return dataModel;
    }

    public void updateViewPer(int user_id,int goods_id) throws SQLException {
        rgDao.updateViewPer(user_id, goods_id);
    }

    public void updateBuyPre(int user_id, int goods_id) throws SQLException {
        rgDao.updateBuyPre(user_id,goods_id);
    }

    public void addUser(int user_id) throws SQLException {
//        System.out.println(user_id);
        List<Integer> list=null;
        list=gDao.getAllGoodsid();
        for(int goods_id:list)
        {
            rgDao.addUser(user_id,goods_id);
        }
//        rgDao.addUser(user.getId());
    }

    public void addGoods(int id) throws SQLException {
        List<Integer>list=null;
        list=uDao.getAllUserid();
        for(int user_id:list)
        {
            rgDao.addUser(user_id,id);
        }

    }
}
