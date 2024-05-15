
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
<%@page import="model.Type" %>
<%@page import="java.util.List"%>
<%@page import="service.TypeService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
  <%--   <script src=""></script>--%>
<%--  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">--%>
<%--  <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">--%>
<%--  <script src="js/bootstrap.min.js"></script>--%>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
  <title>首页</title>
</head>
<body>
<%--  <div class="jumbotron">--%>
<%--    <h1>Hello, world!</h1>--%>
<%--    <p>...</p>--%>
<%--    <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/IndexServlet" role="button">Learn more</a></p>--%>
<%--  </div>--%>
<%--<nav class="navbar navbar-default" style="background: #3c3c3c;color: #f8f8f8;">--%>
<%--  <div class="container-fluid" >--%>
<%--    <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--    <div class="navbar-header">--%>
<%--      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">--%>
<%--        <span class="sr-only">Toggle navigation</span>--%>
<%--        <span class="icon-bar"></span>--%>
<%--        <span class="icon-bar"></span>--%>
<%--        <span class="icon-bar"></span>--%>
<%--      </button>--%>

<%--      <a class="navbar-brand" href="index.jsp">首页</a>--%>
<%--    </div>--%>

<%--    <!-- Collect the nav links, forms, and other content for toggling -->--%>
<%--    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="color: #9acfea">--%>
<%--      <ul class="nav navbar-nav">--%>
<%--        &lt;%&ndash;                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>&ndash;%&gt;--%>
<%--        <li><a href="#">热销</a></li>--%>
<%--        <li class="dropdown">--%>
<%--          <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">商品分类<span class="caret"></span></a>--%>
<%--          <ul class="dropdown-menu">--%>
<%--            <%--%>
<%--              TypeService typeService=new TypeService();--%>
<%--              List<Type>typeList=typeService.getAllType();--%>
<%--              request.setAttribute("typeList",typeList);--%>
<%--//              System.out.println(typeList);--%>
<%--//              for (Type t : typeList) {--%>
<%--//                System.out.println("Name: " + t.getName());}--%>
<%--            %>--%>

<%--              <c:forEach var="t" items="${typeList}">--%>
<%--              <li><a href="${pageContext.request.contextPath}/goods_list?typeid=${t.id}">${t.name}</a></li>--%>
<%--              </c:forEach>--%>

<%--            &lt;%&ndash;                        <li role="separator" class="divider"></li>&ndash;%&gt;--%>
<%--            &lt;%&ndash;                        <li><a href="#">One more separated link</a></li>&ndash;%&gt;--%>
<%--          </ul>--%>
<%--        </li>--%>
<%--      </ul>--%>
<%--      <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/goods_search">--%>
<%--        <div class="form-group">--%>
<%--          <input type="text" class="form-control" placeholder="Search" name="keyword">--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn btn-default">提交</button>--%>
<%--      </form>--%>
<%--      <ul class="nav navbar-nav navbar-right">--%>
<%--        <li><a href="goods_cart.jsp"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></li>--%>
<%--        <li class="dropdown">--%>
<%--          <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">登录--%>
<%--            <span class="caret"></span></a>--%>
<%--          <ul class="dropdown-menu">--%>
<%--            <li><a href="${pageContext.request.contextPath}/user_login.jsp">已有账号-登录</a></li>--%>
<%--            <li><a href="${pageContext.request.contextPath}/user_register.jsp">没有账号-注册</a></li>--%>

<%--          </ul>--%>
<%--        </li>--%>
<%--      </ul>--%>
<%--    </div><!-- /.navbar-collapse -->--%>
<%--  </div><!-- /.container-fluid -->--%>
<%--</nav>--%>
<%--<jsp:include page="header.jsp"></jsp:include>--%>
<c:choose>
    <c:when test="${not empty user}">
        <jsp:include page="header_1.jsp"></jsp:include>

    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>
    </c:otherwise>
</c:choose>

<br>
<br>
<br><br><br><br><br><br>

<div class="jumbotron">
  <div class="container">
    <div class="jumbotron">
      <h1>Weclome!</h1>
      <br><br>
      <p>欢迎来到该网站，点击下面的按钮查看更多！</p>
      <br><br>
      <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/goods_list?typeiId=0" role="button">查看更多</a></p>
    </div>
  </div>
</div>
<br><br><br><br><br>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
