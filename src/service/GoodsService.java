package service;

import dao.GoodsDao;
import model.Goods;
import model.Page;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodsService {
    private GoodsDao gDao=new GoodsDao();
    public List<Map<String,Object>>getGoodsList(int recommendType){
        List<Map<String,Object>>list=null;
        try {
            list=gDao.getGoodsList(recommendType);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public List<Map<String,Object>>getScrollGood(){
        List<Map<String,Object>>list=null;
        try {
            list=gDao.getScorllGood();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
//    public List<Goods>selectGoodsByTypeID(int typeID, int pageNumber,int pageSize){
//        List<Goods>list=null;
//        try {
//            list=gDao.selectGoodsByTypeID(typeID,pageNumber,pageSize);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return list;
//    }
public List<Goods>selectGoodsByTypeID(int typeID){
    List<Goods>list=null;
    try {
        list=gDao.selectGoodsByTypeID(typeID);
//        System.out.println(list);
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return list;
}
//    public Page selectPageByTypeID(int typeID, int pageNumber)
//    {
//        System.out.println("typeID:"+typeID);
//        Page p = new Page();
//        p.setPageNumber(pageNumber);
//        int totalCount=0;
//        try {
//            //通过typeid去查询商品的数量
//            totalCount=gDao.getCountOfGoodsByTypeID(typeID);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        p.SetPageSizeAndTotalCount(8,totalCount);
//        List list=null;
//        try {
//            //分页查询
//            if(typeID>=0)
//            {
//                list=gDao.selectGoodsByTypeID(typeID,pageNumber,8);
//            }
//            else
//            {
//                List goodsidlist=gDao.selectGoodsByTypeID(typeID,pageNumber,8);
////                System.out.println("goods_id:"+goodsidlist);
//                for(int i=0;i<goodsidlist.size();i++){
//                    list.add(gDao.getGoodsById((int)(goodsidlist.get(i))));
//                }
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        p.setList(list);
//        return p;
//    }
    public Page getGoodsRecommendPage(int type,int pageNumber){
        Page p=new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount=gDao.getRecommendCountOfGoodsByTypeID(type);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(8,totalCount);
        List list=null;
        try {
            list=gDao.selectGoodsbyRecommend(type,pageNumber,8);
            for(Goods g : (List<Goods>)list){
                g.setScroll(gDao.isScroll(g));
                g.setHot(gDao.isHot(g));
                g.setNew(gDao.isNew(g));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        p.setList(list);
        return p;

    }
    public Goods getGoodsById(int id){
        Goods g=null;
        try {
            g=gDao.getGoodsById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return g;
    }
    public Page getSearchGoodsPage(String keyword,int pageNumber){
        Page p=new Page();
        p.setPageNumber(pageNumber);
        int totalCount=0;
        try {
            totalCount=gDao.getSearchCount(keyword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(8,totalCount);
        List list=null;
        try {
            list=gDao.selectSearchGoods(keyword,pageNumber,8);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        p.setList(list);
        return p;
    }
    public void addRecommend(int id,int type){
        try {
            gDao.addRecommend(id,type);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void removeRecommend(int id,int type){
        try {
            gDao.removeRecommend(id,type);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void insert(Goods goods){
        try {
            gDao.insert(goods);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void update(Goods goods){
        try {
            gDao.update(goods);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void delete(int id){
        try {
            gDao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void UpdateStock(int stockadd, int id) throws SQLException {
        gDao.UpdateStock(stockadd,id);
    }

    public int getLstId() throws SQLException {
       return gDao.getLastId();
    }
}
