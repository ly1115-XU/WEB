package servlet;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.palette.ColorPalette;
import model.User;
import model.UserImpression;
import service.OrderService;
import service.UserBigDataService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.knowm.xchart.BitmapEncoder;
//import org.knowm.xchart.BitmapEncoder.BitmapFormat;
//import org.knowm.xchart.WordCloud;
//import com.kennycason.kumo.WordCloud;


@WebServlet(name = "UserImpressionServlet",urlPatterns = "/user_impression")
public class UserImpressionServlet extends HttpServlet {
    private OrderService oService=new OrderService();
    private UserService uService=new UserService();
    private UserBigDataService ubdService=new UserBigDataService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int user_id=0;
//        if(request.getParameter("user_id")!=null)
//        {
//            user_id=Integer.getInteger(request.getParameter("user_id"));
//        }
//        List<String>impressionpaint=oService.selectImpression(user_id);
//        List<UserImpression>impression=oService.selectImpression();
//        request.getSession().setAttribute("impressionlist",impressionlist);
        List<User>list=new ArrayList<>();
        try {
            list=uService.getNormalUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<UserImpression>userImpressionList=new ArrayList<>();
        for(User user:list)
        {
            UserImpression userimpression=new UserImpression();
            String register=null;
            Date early=null;
            try {
                early=ubdService.getEarlyDateByUserId(user.getId());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Date currentDate = new Date();
            // 将 Date 转换为
            if(early!=null)
            {
                LocalDate earlyLocalDate = early.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate currentLocalDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                // 计算两个日期之间相差的天数
                long daysDifference = ChronoUnit.DAYS.between(earlyLocalDate, currentLocalDate);

                // 检查天数差是否大于等于 30
                if (daysDifference >= 30) {
                    register="老用户";
                } else {
                    register="新用户";
                }
            }
            else
            {
                register="仅注册用户";
            }


            String action=null;
            int count=0;
            try {
                count=ubdService.getCountByUser(user.getId());
//                System.out.println(count);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(count>10)
            {
                action="活跃用户";
            }
            else
            {
                action="非活跃用户";
            }
            String cost=null;
            double cos=0.0;
            try {
                cos=oService.getCostByUserId(user.getId());
//                System.out.println("啊不是没有吗");
//                System.out.println(cos);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(cos>300)
            {
                cost="高消费用户";
            }
            else if(cos>100)
            {
                cost="中消费用户";
            }
            else
            {
                cost="低消费用户";
            }
            List<String>impression=new ArrayList<>();
            impression=oService.selectImpression(user.getId());
//            System.out.println(impression);
            userimpression.setAction(action);
            userimpression.setUser_id(user.getId());
            userimpression.setCost(cost);
            userimpression.setRegister(register);
            userimpression.setImpression(impression);
            userImpressionList.add(userimpression);



            // 假设你的词频统计存在于一个List中，每个WordFrequency对象包含一个词和对应的词频
            List<WordFrequency> wordFrequencies = new ArrayList<>();
            // 将你的impression数组转换成词频统计List，假设impression是你的数组
//            String[] impression = {"Java", "Java", "Python", "Python", "Python", "JavaScript"};
            for (String word : impression) {
//                boolean exists = false;
//                for (WordFrequency wf : wordFrequencies) {
//                    if (wf.getWord().equals(word)) {
//                        wf.
//                        wf.setFrequency(wf.getFrequency() + 1);
//                        exists = true;
//                        break;
//                    }
//                }
//                if (!exists) {
//                    wordFrequencies.add(new WordFrequency(word, 1));
//                }
                wordFrequencies.add(new WordFrequency(word, 1));
            }

            // 创建词云对象
            final Dimension dimension = new Dimension(600, 100);
//            final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
            WordCloud wordCloud=new WordCloud(dimension,CollisionMode.RECTANGLE);
            wordCloud.setPadding(2);
            wordCloud.setBackgroundColor(Color.WHITE);
            wordCloud.setColorPalette(new ColorPalette(new Color(0xFF0000), new Color(0x0000FF), new Color(0x00FF00),
                    new Color(0xFFFF00), new Color(0xFF00FF)));
            wordCloud.setFontScalar(new LinearFontScalar(5, 10));
//            # 使用LogFontScalar进行字体大小自动调整
            // wordloud = WordCloud(font_path=get_font_path('SourceHanSerifSC-Regular.otf'), font_scalar=LogFontScalar())
//            wordCloud.setKumoFont(new KumoFont("Arial", KumoFont.BOLD));

            // 将词频添加到词云中
            wordCloud.build(wordFrequencies);
//            System.out.println(wordFrequencies);
            // 生成词云图片
            wordCloud.writeToFile("images\\wordcloud"+user.getId()+".png");

        }
        request.getSession().setAttribute("userImpressionList",userImpressionList);
        request.getRequestDispatcher("user_impression.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
