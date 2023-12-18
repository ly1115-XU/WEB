<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>

</head>
<body>
<c:choose>
    <c:when test="${not empty user}">
        <jsp:include page="header_1.jsp"></jsp:include>

    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>
    </c:otherwise>
</c:choose>

<div class="cart-items">
<%--    <div class="alert alert-danger">很抱歉的通知您，因为本网站还在开发中，因此提交订单时，购物车只能有一样物品，否则后台会记录失败</div>--%>

    <div class="content">
        <br>
        <br>

        <h2>购物车</h2>
        <c:forEach items="${order.itemMap}" var="item">
<%--            <div class="cart-header col-md-6">--%>
<%--                <div class="cart-item simpleCart_shelfItem">--%>
<%--                    <div class="cart-item cyc">--%>
<%--                        <a href="${pageContext.request.contextPath}/goods_detail?id=${item.key}" >--%>
<%--                            <img src="${item.value.goods.cover}" class="img-responsive">--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                    <div class="cart-item-info">--%>
<%--                        <h3><a href="${pageContext.request.contextPath}/goods_detail?id=${item.key}">${item.value.goods.name}</a></h3>--%>
<%--                        <h3><span>单价：￥ ${item.value.price}</span></h3>--%>
<%--                        <h3><span>数量：${item.value.amount}</span></h3>--%>
<%--                        <a class="btn btn-info" href="javascript:buy(${item.key});">增加</a>--%>
<%--                        <a class="btn btn-warning" href="javascript:lessen(${item.key});">减小</a>--%>
<%--                        <a class="btn btn-danger" href="javascript:deletes(${item.key});">删除</a>--%>
<%--                    </div>--%>
<%--                    <div class="clearfix"></div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <c:if test="${!empty failMsg}">--%>
<%--                <div class="alert alert-danger">${failMsg}</div>--%>
<%--            </c:if>--%>
<%--            <div class="cart-header card mb-3" style="max-width: 540px;">--%>
<%--               <div class="cart-item simpleCart_shelfItem"> &lt;%&ndash; row-no-gutters&ndash;%&gt;--%>
<%--                    <div class="cart-item cyc col-md-4">--%>
<%--                        <a href="${pageContext.request.contextPath}/goods_detail?id=${item.key}">--%>
<%--                            <img src="${item.value.goods.cover}" class="img-responsive">--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--&lt;%&ndash;                    <div class="col-md-8">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="cart-item-info card-body">&ndash;%&gt;--%>
<%--                   <div class="cart-item-info">--%>
<%--&lt;%&ndash;                        <div class="card-body ">&ndash;%&gt;--%>
<%--                            <h3><a href="${pageContext.request.contextPath}/goods_detail?id=${item.key}">${item.value.goods.name}</a></h3>--%>
<%--                            <h3><span>单价：￥ ${item.value.price}</span></h3>--%>
<%--                            <h3><span>数量：${item.value.amount}</span></h3>--%>
<%--                            <a class="btn btn-info" href="javascript:buy(${item.key});">增加</a>--%>
<%--                            <a class="btn btn-warning" href="javascript:lessen(${item.key});">减小</a>--%>
<%--                            <a class="btn btn-danger" href="javascript:deletes(${item.key});">删除</a>--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--                   </div>--%>
<%--                        <div class="clearfix"></div>--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                </div>--%>
<%--            </div>--%>

            <div class="cart-header col-md-6">
                <div class="cart-sec simpleCart_shelfItem">
                    <div class="cart-item cyc">
                        <a href="${pageContext.request.contextPath}/goods_detail?id=${item.key}">
                            <img src="${item.value.goods.cover}" class="img-responsive">
                        </a>
                    </div>
                    <h3><a href="${pageContext.request.contextPath}/goods_detail?id=${item.key}">${item.value.goods.name}</a> </h3><br>
                    <h3><span>单价：￥${item.value.price}</span></h3><br>
                    <h3><span>数量：${item.value.amount}</span></h3><br>
                    <a class="btn btn-info" href="javascript:buy(${item.key});">增加</a>
                    <a class="btn btn-warning" href="javascript:lessen(${item.key});">减小</a>
                    <a class="btn btn-danger" href="javascript:deletes(${item.key});">删除</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </c:forEach>
        <div class="cart-header col-md-12">
            <hr>
            <h3>订单总金额：￥ ${order.total}</h3>
            <a class="btn btn-success btn-lg" style="margin-left: 74%" href="${pageContext.request.contextPath}/order_submit">提交订单</a>
        </div>
    </div>
</div>
<br>
<%--<%@include file="footer.jsp"%>--%>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</body>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</html>
