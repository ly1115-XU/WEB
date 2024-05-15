package service;

import dao.ViewDao;
import model.View;

import java.sql.SQLException;
import java.util.List;

public class ViewService {
    private ViewDao vDao=new ViewDao();
    public List<View> getViewListByTypeId(int typeid) throws SQLException {//根据typeid提取出所有的信息
        List<View>list=null;
        list=vDao.selectByTypeid(typeid);

//        if(list==null)
//        {
//            System.out.println("list为空");
//        }
//        System.out.println(list);//
        return list;
    }

    public void addView(View view) throws SQLException {//添加浏览记录
        if(view==null)
        {
            System.out.println("view为空");
        }
//        System.out.println(view.getGoodsId()+" "+view.getTypeId());

        if(vDao.selectByGoodsid(view.getGoodsId()))
        {

            vDao.updateView(view);
        }
        else
        {
            vDao.addView(view);
        }
    }


    public List<Integer> getGoodsid() throws SQLException {
        List<Integer>idList=null;
        idList=vDao.getGoodsid();
//        System.out.println(idList);
        return idList;
    }
}
