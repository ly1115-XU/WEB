<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
<%@page import="model.Type" %>
<%@page import="java.util.List"%>
<%@page import="service.TypeService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<%--<head>--%>
<%--    &lt;%&ndash;   <script src=""></script>&ndash;%&gt;--%>
<%--    &lt;%&ndash;  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">&ndash;%&gt;--%>
<%--    &lt;%&ndash;  <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">&ndash;%&gt;--%>
<%--    &lt;%&ndash;  <script src="js/bootstrap.min.js"></script>&ndash;%&gt;--%>
<%--    <meta name="viewport" content="width=decive-width,initial-scale=1">--%>
<%--    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">--%>
<%--    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">--%>
<%--    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>--%>
<%--    <script type="text/javascript" src="js/bootstrap.min.js"></script>--%>
<%--    <link rel="stylesheet" type="text/css" href="css/style.css">--%>
<%--    <script type="text/javascript" src="js/layer.js"></script>--%>
<%--    <script type="text/javascript" src="js/cart.js"></script>--%>
<%--&lt;%&ndash;    <title>首页</title>&ndash;%&gt;--%>
<%--</head>--%>
<body>
<%--  <div class="jumbotron">--%>
<%--    <h1>Hello, world!</h1>--%>
<%--    <p>...</p>--%>
<%--    <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/IndexServlet" role="button">Learn more</a></p>--%>
<%--  </div>--%>
<nav class="navbar navbar-default" style="background: #3c3c3c;color: #f8f8f8;">
    <div class="container-fluid" >
        <!-- Brand and toggle get grouped for better mobile display -->
        <%--        <div class="navbar-header">--%>
        <%--            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">--%>
        <%--                <span class="sr-only">Toggle navigation</span>--%>
        <%--                <span class="icon-bar"></span>--%>
        <%--                <span class="icon-bar"></span>--%>
        <%--                <span class="icon-bar"></span>--%>
        <%--            </button>--%>

        <%--            <a class="navbar" href="index.jsp">首页</a>--%>
        <%--        </div>--%>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="color: #9acfea">
            <ul class="nav navbar-nav">
                <%--                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
                <li><a></a></li>
                <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/goods_list?typeid=0">热销</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">商品分类<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <%
                            TypeService typeService=new TypeService();
                            List<Type>typeList=typeService.getAllType();
                            request.setAttribute("typeList",typeList);
//              System.out.println(typeList);
//              for (Type t : typeList) {
//                System.out.println("Name: " + t.getName());}
                        %>

                        <c:forEach var="t" items="${typeList}">
                            <li><a href="${pageContext.request.contextPath}/goods_list?typeid=${t.id}">${t.name}</a></li>
                        </c:forEach>

                        <%--                        <li role="separator" class="divider"></li>--%>
                        <%--                        <li><a href="#">One more separated link</a></li>--%>
                    </ul>
                </li>
            </ul>
            <%--            <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/goods_search">--%>
            <%--                <div class="form-group">--%>
            <%--                    <input type="text" class="form-control" placeholder="Search" name="keyword">--%>
            <%--                </div>--%>
            <%--                <button type="submit" class="btn btn-default">提交</button>--%>
            <%--            </form>--%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="goods_cart.jsp"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></li>
                <li><a href="${pageContext.request.contextPath}/order_list.jsp"><span>我的订单</span></a></li>
                <li><a href="${pageContext.request.contextPath}/user_center.jsp"><span>个人中心</span></a></li>
<%--                <li class="dropdown">--%>
<%--                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">登录--%>
<%--                        <span class="caret"></span></a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li><a href="${pageContext.request.contextPath}/user_login.jsp">已有账号-登录</a></li>--%>
<%--                        <li><a href="${pageContext.request.contextPath}/user_register.jsp">没有账号-注册</a></li>--%>

<%--                    </ul>--%>
<%--                </li>--%>
                <li><a href="${pageContext.request.contextPath}/exit"><span>退出登录</span></a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>
