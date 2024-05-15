package servlet;

import model.Goods;
import model.User;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.Preference;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import service.GoodsService;
import service.RecommendGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import org.apache.mahout.cf.taste.recommender.RecommendedItemSimilarity;

//import org.apache.mahout.cf.taste.impl.similarity.CosineSimilarity;



@WebServlet(name = "RecommendGoodsServlet",urlPatterns = "/recommend_servlet")
public class RecommendGoodsServlet extends HttpServlet {
    private RecommendGoodsService rgService=new RecommendGoodsService();
    private MySQLJDBCDataModel dataModel;
    private GoodsService gService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=null;
        user=(User)request.getSession().getAttribute("user");
        Long user_id=(long)user.getId();
        try {
            dataModel=rgService.getdataModel();
        } catch (SQLException | PropertyVetoException throwables) {
            throwables.printStackTrace();
        }
        // 计算相似度
        ItemSimilarity itemSimilarity = null;
        try {
            itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
        } catch (TasteException e) {
            e.printStackTrace();
        }
        //创建一个推荐的商品List
        Set<Integer> RecommendList=new HashSet<>();
        // 构建推荐器，使用基于物品的协同过滤推荐
        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);

        List<RecommendedItem> recommendedItemList = new ArrayList<>();

        List<Long> nonZeroColumns = new ArrayList<>();
        PreferenceArray preferences = null;
        try {
            preferences = dataModel.getPreferencesFromUser(user.getId());
        } catch (TasteException e) {
            e.printStackTrace();
        }
//        System.out.println(preferences);
        for (Preference preference : preferences) {
                if (preference.getValue() != 0.0f) {
                    nonZeroColumns.add(preference.getItemID());
                }
            }
//        System.out.println(nonZeroColumns);
        for (Long itemid:nonZeroColumns){
//            System.out.println(itemid);
//            System.out.println(user.getId());
            try {
                // 根据用户已经浏览或者加购过的商品，推荐2个相似的商品
                recommendedItemList = recommender.recommendedBecause(user.getId(), itemid, 2);
            } catch (TasteException e) {
                e.printStackTrace();
            }
            // 获取用户浏览过的所有商品


//        System.out.println("使用基于物品的协同过滤算法");
//        System.out.println("根据用户2当前浏览的商品2，推荐2个相似的商品");
//            System.out.println(recommendedItemList);
            for (RecommendedItem recommendedItem : recommendedItemList) {
//            System.out.println(recommendedItem);
//                Goods goods=new Goods();
//                goods=gService.getGoodsById((int)recommendedItem.getItemID());
//                System.out.println(goods);
                RecommendList.add((int)recommendedItem.getItemID());
            }
        }
//        System.out.println(RecommendList.size());
        List<Goods>RecommendGoodsList=new ArrayList<>();
        for(int goodsid:RecommendList){
            Goods goods=null;
            goods=gService.getGoodsById(goodsid);
            RecommendGoodsList.add(goods);
        }
//        System.out.println(RecommendGoodsList);
        request.getSession().setAttribute("RecommendGoodsList",RecommendGoodsList);
        request.getRequestDispatcher("Recommend_Goods_List.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
