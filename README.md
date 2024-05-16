# WEB

#### 介绍
网络开发应用大作业

#### 软件架构
软件架构说明

├─src  
│  │  c3p0-config.xml    ***cp30数据池的配置***  
│  │    
│  ├─com  
│  │  └─company  
│  │          Main.java  
│  │            
│  ├─dao  
│  │      AdminBigDataDao.java    ***管理人员大数据信息与数据库交互***  
│  │      GoodsDao.java    ***商品信息与大数据交互***  
│  │      OperationItemDao.java    ***操作日志***  
│  │      OrderDao.java    ***订单信息***  
│  │      OrderItemDao.java    ***订单项***  
│  │      RecommendGoodsDao.java    ***推荐商品***  
│  │      TypeDao.java    ***商品种类***  
│  │      UserBigDataDao.java    ***普通用户大数据***  
│  │      UserDao.java    ***普通用户信息***  
│  │      ViewDao.java    ***浏览记录***  
│  │      
│  ├─filter  
│  │      EncodeFilter.java  ***编码***  
│  │        
│  ├─model  ***基本类***  
│  │      AdminBigdata.java  ***管理人员&&销售人员基本类***  
│  │      Goods.java  ***商品***  
│  │      GoodsSale.java  ***售卖情况***  
│  │      OperationItem.java  ***操作日志***  
│  │      Order.java  ***订单***  
│  │      OrderItem.java  ***订单项***  
│  │      Page.java  ***分页***  
│  │      Recommend.java  ***推荐商品***  
│  │      Sale.java  ***销售统计***  
│  │      Sold.java  ***售卖记录***  
│  │      Type.java  ***种类***  
│  │      User.java  ***用户***  
│  │      UserBigdata.java  ***普通用户大数据***  
│  │      UserImpression.java  ***用户画像***  
│  │      View.java  ***浏览记录***  
│  │        
│  ├─service  ***业务层***  
│  │      AdminBigDataService.java  ***管理人员&&销售人员大数据***  
│  │      GoodsService.java  ***商品***  
│  │      OperationItemService.java  ***操作日志项***  
│  │      OrderItemService.java  ***订单项***  
│  │      OrderService.java  ***订单***  
│  │      RecommendGoodsService.java  ***推荐商品***  
│  │      TypeService.java  ***种类***  
│  │      UserBigDataService.java  ***普通用户大数据***  
│  │      UserService.java  ***用户***  
│  │      ViewService.java  ***浏览记录***  
│  │        
│  ├─servlet  ***控制层***  
│  │      ADMINGoodsAddServlet.java  ***销售人员商品添加***  
│  │      ADMINGoodsDeleteServlet.java  ***销售人员商品删除***  
│  │      ADMINGoodsDetailServlet.java  ***销售人员商品细节查看***  
│  │      ADMINGoodsEditServlet.java  ***销售人员细节编辑***  
│  │      ADMINGoodsEditshowServlet.java  ***销售人员细节获取展示***  
│  │      ADMINGoodsListServlet.java   ***销售人员负责商品列表展示***  
│  │      ADMINGoodsSaleServlet.java  ***销售人员商品售卖***  
│  │      ADMINGoodsStatueServlet.java   ***商品状态***  
│  │      ADMINOrderDeleteServlet.java  ***用户订单删除***  
│  │      ADMINOrderListServlet.java  ***用户订单列表***  
│  │      ADMINOrderStatusServlet.java  ***用户订单状态改变***  
│  │      ADMINSaleShowServlet.java  ***销售情况展示***  
│  │      ADMINSaleStatsServlet.java  ***销售状态展示***  
│  │      ADMINSoldlistServlet.java  ***售卖列表***  
│  │      ADMINStockAddServlet.java  ***商品库存添加***  
│  │      ADMINUserAddServlet.java  ***管理人员添加新的销售人员***  
│  │      ADMINUserChangeServlet.java  ***销售人员口令更改***  
│  │      ADMINUserDeleteServlet.java  ***销售人员删除***  
│  │      ADMINUserEditServlet.java  ***销售人员信息编辑***  
│  │      ADMINUserListServlet.java  ***销售人员列表***  
│  │      ADMINViewListServlet.java  ***商品浏览记录***  
│  │      CloseServlet.java  ***窗口关闭***  
│  │      ExitServlet.java  ***自动退出***  
│  │      GoodsBuyServlet.java  ***商品购买***  
│  │      GoodsDeleteServlet.java  ***商品删除***  
│  │      GoodsDetailServlet.java  ***商品细节***  
│  │      GoodsLessenServlet.java  ***商品数量减小***  
│  │      GoodsListServlet.java  ***商品列表***   
│  │      GoodsSearchServlet.java  ***商品搜索***  
│  │      HotGoodsServlet.java  ***热销商品***  
│  │      LogOffServlet.java  ***用户注销***  
│  │      OrderConfirmServlet.java  ***订单确认***  
│  │      OrderListServlet.java  ***订单列表***  
│  │      OrderSumbitServlet.java  ***订单提交***  
│  │      RecommendGoodsServlet.java  ***推荐商品***  
│  │      UserChangeAddressServlet.java  ***用户基本信息更改***  
│  │      UserChangePwdServlet.java  ***用户密码更改***  
│  │      UserImpressionServlet.java  ***用户画像***  
│  │      UserLoginServlet.java  ***用户登录***  
│  │      UserRegisterServlet.java  ***用户注册***  
│  │        
│  └─utils  
│          DBUtil.java  ***数据库连接***  
│          PriceUtils.java  ***价格的处理***  
│            
└─web  ***前端界面展示***    
    │  admin_goods_add.jsp  ***商品添加***  
    │  admin_goods_edit.jsp  ***商品细节编辑***  
    │  admin_goods_list.jsp  ***商品展示***  
    │  admin_goods_sale.jsp  ***商品售卖情况***  
    │  admin_goods_statue.jsp  ***商品状态***  
    │  admin_order_list.jsp  ***订单展示***  
    │  admin_sale_show.jsp  ***售卖展示***  
    │  admin_sale_stats.jsp  ***销售统计***  
    │  admin_sold.jsp  ***商品售卖情况***  
    │  admin_stock_add.jsp  ***商品库存更改***  
    │  admin_user_add.jsp  ***销售人员添加***  
    │  admin_user_change.jsp  ***销售人员口令更改***  
    │  admin_user_list.jsp  ***销售人员列表***  
    │  admin_view_list.jsp  ***商品被浏览记录***  
    │  footer.jsp  ***页脚***  
    │  goods_cart.jsp  ***购物车***  
    │  goods_detail.jsp  ***商品细节***  
    │  goods_list.jsp  ***商品列表***  
    │  goods_search.jsp  ***商品搜索***  
    │  header.jsp  ***网站首页导航栏***  
    │  header1.jsp  ***销售人员导航栏***  
    │  header_1.jsp  ***用户登录导航栏***  
    │  header_manage.jsp  ***管理人员导航栏***   
    │  index.jsp  ***网站首页***  
    │  index1.jsp  ***销售人员首页***  
    │  index_manage.jsp  ***管理人员首页***  
    │  order_list.jsp  ***订单列表***  
    │  order_success.jsp  ***订单提交成功***  
    │  order_sumbit.jsp  ***订单提交***  
    │  page.jsp  ***页码***  
    │  Recommend_Goods_List.jsp  ***推荐商品列表***  
    │  user_center.jsp  ***个人中心界面***  
    │  user_impression.jsp  ***用户画像展示***  
    │  user_login.jsp  ***用户登录界面***  
    │  user_register.jsp  ***用户注册界面***  
    │      
    ├─css    ***前端样式***  
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
    └─WEB-INF  ***依赖***  
        │  log4j.xml  
        │  pom.xml  
        │  web.xml  
        │    
        └─lib  ***用到的jar包***  
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

1.  在电脑或者平板的浏览器进入网站39.101.163.179


#### 使用说明

1.  普通用户登录口令：  
    用户名：2@2.com  
    密码：2  
    或者用户名：1@1.com  
        密码：1
    登陆前可以进行浏览商品和热销商品，可以查看商品细节，可以进行分类查看，可以进行登录和用户注册。
    登陆后可以进行个人信息的更改，密码更改，可以加购商品，提交订单，可以查看推荐商品。
3.  销售人员登录口令：  
   用户名：11@11.com/22@22.com/33@33.com/44@44.com  
   密码：11/22/33/44
   登陆后可以查看订单，可以进行商品管理，比如添加商品，删除和更改商品细节。可以查看负责的商品被浏览记录，可以查看所负责商品的售出记录。
5.  管理人员登录口令：  
    用户名：123@123.com  
    密码：123  
    登陆后可以进行订单查看，进行销售人员管理：添加销售人员，删除销售人员，更改销售人员的登录口令。  
    可以分类查看商品的销售数量，可以通过点击销售用户名和销售种类查看销售商品的详细类目。  
    可以查看所有商品的销售统计和销售情况，可以进行库存管理。
    可以查看用户画像。  

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
