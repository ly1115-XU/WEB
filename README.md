# WEB

#### 介绍
网络开发应用大作业

#### 软件架构
软件架构说明

├─src  
│  │  c3p0-config.xml  cp30数据池的配置
│  │    
│  ├─com  
│  │  └─company  
│  │          Main.java  
│  │            
│  ├─dao  
│  │      AdminBigDataDao.java  
│  │      GoodsDao.java  
│  │      OperationItemDao.java  
│  │      OrderDao.java  
│  │      OrderItemDao.java  
│  │      RecommendGoodsDao.java  
│  │      TypeDao.java  
│  │      UserBigDataDao.java  
│  │      UserDao.java  
│  │      ViewDao.java  
│  │      
│  ├─filter  
│  │      EncodeFilter.java  
│  │        
│  ├─model  
│  │      AdminBigdata.java  
│  │      Goods.java  
│  │      GoodsSale.java  
│  │      OperationItem.java  
│  │      Order.java  
│  │      OrderItem.java  
│  │      Page.java  
│  │      Recommend.java  
│  │      Sale.java  
│  │      Sold.java  
│  │      Type.java  
│  │      User.java  
│  │      UserBigdata.java  
│  │      UserImpression.java  
│  │      View.java  
│  │        
│  ├─service  
│  │      AdminBigDataService.java  
│  │      GoodsService.java  
│  │      OperationItemService.java  
│  │      OrderItemService.java  
│  │      OrderService.java  
│  │      RecommendGoodsService.java  
│  │      TypeService.java  
│  │      UserBigDataService.java  
│  │      UserService.java  
│  │      ViewService.java  
│  │        
│  ├─servlet  
│  │      ADMINGoodsAddServlet.java  
│  │      ADMINGoodsDeleteServlet.java  
│  │      ADMINGoodsDetailServlet.java  
│  │      ADMINGoodsEditServlet.java  
│  │      ADMINGoodsEditshowServlet.java  
│  │      ADMINGoodsListServlet.java  
│  │      ADMINGoodsSaleServlet.java  
│  │      ADMINGoodsStatueServlet.java  
│  │      ADMINOrderDeleteServlet.java  
│  │      ADMINOrderListServlet.java  
│  │      ADMINOrderStatusServlet.java  
│  │      ADMINSaleShowServlet.java  
│  │      ADMINSaleStatsServlet.java  
│  │      ADMINSoldlistServlet.java  
│  │      ADMINStockAddServlet.java  
│  │      ADMINUserAddServlet.java  
│  │      ADMINUserChangeServlet.java  
│  │      ADMINUserDeleteServlet.java  
│  │      ADMINUserEditServlet.java  
│  │      ADMINUserListServlet.java  
│  │      ADMINViewListServlet.java  
│  │      CloseServlet.java  
│  │      ExitServlet.java  
│  │      GoodsBuyServlet.java  
│  │      GoodsDeleteServlet.java  
│  │      GoodsDetailServlet.java  
│  │      GoodsLessenServlet.java  
│  │      GoodsListServlet.java  
│  │      GoodsSearchServlet.java  
│  │      HotGoodsServlet.java  
│  │      LogOffServlet.java  
│  │      OrderConfirmServlet.java  
│  │      OrderListServlet.java  
│  │      OrderSumbitServlet.java  
│  │      RecommendGoodsServlet.java  
│  │      UserChangeAddressServlet.java  
│  │      UserChangePwdServlet.java  
│  │      UserImpressionServlet.java  
│  │      UserLoginServlet.java  
│  │      UserRegisterServlet.java  
│  │        
│  └─utils  
│          DBUtil.java  
│          PriceUtils.java  
│            
└─web  
    │  admin_goods_add.jsp  
    │  admin_goods_edit.jsp  
    │  admin_goods_list.jsp  
    │  admin_goods_sale.jsp  
    │  admin_goods_statue.jsp  
    │  admin_order_list.jsp  
    │  admin_sale_show.jsp  
    │  admin_sale_stats.jsp  
    │  admin_sold.jsp  
    │  admin_stock_add.jsp  
    │  admin_user_add.jsp  
    │  admin_user_change.jsp  
    │  admin_user_list.jsp  
    │  admin_view_list.jsp  
    │  footer.jsp  
    │  goods_cart.jsp  
    │  goods_detail.jsp  
    │  goods_list.jsp  
    │  goods_search.jsp  
    │  header.jsp  
    │  header1.jsp  
    │  header_1.jsp  
    │  header_manage.jsp  
    │  index.jsp  
    │  index1.jsp  
    │  index_manage.jsp  
    │  order_list.jsp  
    │  order_success.jsp  
    │  order_sumbit.jsp  
    │  page.jsp  
    │  Recommend_Goods_List.jsp  
    │  user_center.jsp  
    │  user_impression.jsp  
    │  user_login.jsp  
    │  user_register.jsp  
    │      
    ├─css    
    │      bootstrap-theme.css  
    │      bootstrap-theme.css.map  
    │      bootstrap-theme.min.css  
    │      bootstrap-theme.min.css.map  
    │      bootstrap.css  
    │      bootstrap.css.map  
    │      bootstrap.min.css  
    │      bootstrap.min.css.map  
    │      flexslider.css  
    │      layer.css  
    │      style.css  
    │      style1.css  
    │        
    ├─fonts  
    │      glyphicons-halflings-regular.eot  
    │      glyphicons-halflings-regular.svg  
    │      glyphicons-halflings-regular.ttf  
    │      glyphicons-halflings-regular.woff   
    │      glyphicons-halflings-regular.woff2  
    │      Marvel-Regular.ttf  
    │      Roboto-Regular.ttf  
    │        
    ├─images  
    │      alipay.jpg  
    │      offline.png  
    │      slid.jpg  
    │      slid2.jpg  
    │      wechat.jpg  
    │      wordcloud1.png  
    │      wordcloud131.png  
    │      wordcloud132.png  
    │      wordcloud133.png  
    │      wordcloud134.png  
    │      wordcloud138.png  
    │      wordcloud2.png  
    │       
    ├─js  
    │      bootstrap.js  
    │      bootstrap.min.js  
    │      cart.js  
    │      impression.js  
    │      jquery-3.7.1.js  
    │      jquery.flexslider.js  
    │      layer.js  
    │      npm.js  
    │        
    └─WEB-INF  
        │  log4j.xml  
        │  pom.xml  
        │  web.xml  
        │    
        └─lib  
                asm-9.2.jar  
                c3p0-0.9.1.2.jar  
                cglib-3.3.0.jar  
                commons-beanutils-1.8.3.jar  
                commons-dbutils-1.4.jar  
                commons-fileupload-1.2.1.jar  
                commons-io-1.4.jar  
                commons-logging-1.1.1.jar  
                commons-math3-3.6.1.jar  
                guava-32.1.2-jre.jar  
                hamcrest-all-1.3.jar  
                javax.ejb.jar  
                javax.jms.jar  
                javax.persistence.jar  
                javax.resource.jar  
                javax.servlet.jar  
                javax.servlet.jsp.jar  
                javax.servlet.jsp.jstl.jar  
                javax.transaction.jar  
                json-20210307.jar  
                jsp-api.jar  
                jstl.jar  
                kumo-1.5.jar  
                kumo-core-1.13.jar  
                kumo-tokenizers-1.13.jar  
                lambdaj-2.3.3.jar  
                language-all-6.4.jar  
                log4j-1.2.17.jar  
                mahout-core-0.9.jar  
                mahout-integration-0.9.jar
                mahout-math-0.13.0.jar  
                mahout-math-0.9.jar  
                mail.jar  
                mchange-commons-java-0.2.20.jar  
                method-interceptor-1.0.1.jar  
                mysql-connector-java-8.0.11.jar  
                objenesis-3.2.jar  
                servlet-api.jar  
                slf4j-api-1.7.30.jar  
                slf4j-simple-1.7.30.jar  
                standard.jar  
                xchart-3.5.2.jar  
                xchart-demo-3.8.0.jar  
                

#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
