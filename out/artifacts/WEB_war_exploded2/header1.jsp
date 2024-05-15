<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
<%@page import="model.Type" %>
<%@page import="java.util.List"%>
<%@page import="service.TypeService" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script>
        window.addEventListener("unload", function(event) {
            //关闭网站时
            // 向 Servlet 发送请求
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "CloseServlet", true);
            xhr.send();
        });
    </script>
</head>
<body>
<%--<%--%>
<%--%>--%>
<nav class="navbar navbar-default" style="background: #3c3c3c ;color: #3c3c3c;">
    <div class="container-fluid" >
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="color: #9acfea">
            <ul class="nav navbar-nav">
                <%--                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
                <li><a></a></li>
                <li><a href="index1.jsp">首页</a></li>
                    
                <li><a href="${pageContext.request.contextPath}/adminorder_list">订单管理</a></li>


<%--                <li><a href="${pageContext.request.contextPath}/adminuser_list">用户管理</a></li>--%>
<%--                <li><a href="${pageContext.request.contextPath}/admingoods_statue?type=${user.admintype}">商品状态</a> </li>--%>
                <li><a href="${pageContext.request.contextPath}/admingoods_list?type=${user.admintype}">商品管理</a></li>
                <li><a href="${pageContext.request.contextPath}/adminview_list?type=${user.admintype}">浏览记录</a> </li>
                <li><a href="${pageContext.request.contextPath}/adminorderitems?type=${user.admintype}">销售统计</a> </li>
<%--                <li><a href="${pageContext.request.contextPath}/statution.jsp"></a></li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <li><a href="${pageContext.request.contextPath}/exit"><span>退出</span></a></li>


            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>

