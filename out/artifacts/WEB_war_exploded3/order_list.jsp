<%@ page import="model.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="service.OrderService" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的订单</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
</head>
<body>
<%--<%@include file="header.jsp"%>--%>
<c:choose>
    <c:when test="${not empty user}">
        <jsp:include page="header_1.jsp"></jsp:include>

    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>
    </c:otherwise>
</c:choose>

<%
    User u=(User)request.getSession().getAttribute("user");
    OrderService oService=new OrderService();
    if(u==null) {
        request.setAttribute("failMsg","你还未登录，请登陆后再查看！");
        request.getRequestDispatcher("user_login.jsp").forward(request,response);
    }
    List<Order> list=oService.selectAll(u.getId());
    request.getSession().setAttribute("orderlist",list);
%>
<div class="cart-items">
    <div class="container">
        <h2>我的订单</h2>
        <table class="table table-bordered table-hover">
            <tr>
                <th width="10%">ID</th>
                <th width="10%">总价</th>
                <th width="20%">商品详情</th>
                <th width="30%">收获信息</th>
                <th width="10%">订单状态</th>
                <th width="10%">支付方式</th>
                <th width="10%">下单时间</th>
            </tr>
            <c:forEach items="${orderlist}" var="order">
                <tr>
                    <td><p>${order.id}</p></td>
                    <td><p>${order.total}</p></td>
                    <td>
                        <c:forEach items="${order.itemList}" var="item">
                            <p>${item.goodsName}(${item.price}) × ${item.amount}</p>
                        </c:forEach>
                    </td>
                    <td>
                        <p>收货人：${order.name}</p>
                        <p>收获号码：${order.phone}</p>
                        <p>收获地址：${order.address}</p>
                    </td>
                    <td>
                        <p>
                            <c:if test="${order.status==2}"><span style="color: green">已付款</span> </c:if>
                            <c:if test="${order.status==3}"><span style="color: cornflowerblue">已发货</span></c:if>
                            <c:if test="${order.status==4}"><span style="color: black">已完成</span></c:if>
                        </p>
                    </td>
                    <td>
                        <p>
                            <c:if test="${order.paytype==1}">微信</c:if>
                            <c:if test="${order.paytype==2}">支付宝</c:if>
                            <c:if test="${order.paytype==3}">货到付款</c:if>
                        </p>
                    </td>
                    <td><p>${order.datetime}</p></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</body>
</html>