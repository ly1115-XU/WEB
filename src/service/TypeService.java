package service;

import dao.TypeDao;
import model.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeService {
    TypeDao tDao=new TypeDao();
    //查询全部
    public List<Type> getAllType(){
        List<Type>list=new ArrayList<>();
        try {
            list=tDao.getAllType();
//            System.out.println("执行：");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public Type selectTypeNameID(int typeid){
        Type type=null;
        try {
            type=tDao.selectTypeNameByID(typeid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return type;
    }
    public Type select(int id) {
        Type t=null;
        try {
            t = tDao.select(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public void insert(Type t) {
        try {
            tDao.insert(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Type t) {
        try {
            tDao.update(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean delete(int id) {
        try {
            tDao.delete(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Type selectByGoodsId(int goodsid) {
        Type type= null;
        try {
            type = tDao.selectTypeByGoodsID(goodsid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return type;
    }

    public String getTypeNameByID(int typeid) throws SQLException {
        String typename=null;
        typename=tDao.getTypeNameByID(typeid);
//        System.out.println(typename+"?");
        return typename;
    }
}
