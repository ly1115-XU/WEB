<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单提交</title>
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
<%--<%@include file="header.jsp"%>--%>
<c:choose>
    <c:when test="${not empty user}">
        <jsp:include page="header_1.jsp"></jsp:include>
<%--        <%@include file="header_1.jsp"%>--%>

    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>
<%--        <jsp:include page="header.jsp"></jsp:include>--%>
    </c:otherwise>
</c:choose>
<%--<c:if --%>

<div class="cart-items">
    <div class="container">
        <h2>确认收货信息</h2>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/order_confirm" method="post" id="payform">
            <div class="row">
                <label class="control-label col-md-1">收货人</label>
                <div class="col-md-6">
                    <input type="text" class="from-control" name="name" value="${username}" style="height: auto;padding: 10px;" placeholder="输入收货人" required="required">

                </div>
            </div>
            <br>
            <div class="row">
                <label class="control-label col-md-1">收货电话</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="phone" value="${user.phone}" style="height: auto;padding: 10px;" placeholder="请输入收货电话" required="required">
                </div>
            </div>
            <br>
            <div class="row">
                <label class="control-label col-md-1">收货地址</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="address" value="${user.address}" style="height: auto;padding:10px;" placeholder="请输入收货地址">
                </div>
            </div>
            <br><hr><br>
            <h2>选择支付方式</h2>
            <h3>支付金额：￥${order.total}</h3><br><br>
            <div class="col-sm-6 col-md-4 col-lg-3">
                <label>
                    <div class="thumbnail">
                        <input type="radio" name="paytype" value="1" checked="checked">
                        <img src="images/wechat.jpg" alt="微信支付">

                    </div>
                </label>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3">
                <label>
                    <div class="thumbnail">
                        <input type="radio" name="paytype" value="2" checked="checked">
                        <img src="images/alipay.jpg" alt="支付宝支付">

                    </div>
                </label>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3">
                <label>
                    <div class="thumbnail">
                        <input type="radio" name="paytype" value="3" checked="checked">
                        <img src="images/offline.png" alt="货到付款">

                    </div>
                </label>
            </div>
            <div class="clearfix"></div>
            <div class="register-but text-center">
                <input type="submit" value="确认订单">
                <div class="clearfix"></div>
            </div>

        </form>
    </div>
</div>
<script type="text/javascript">
    function dopay(paytype){
        $("#paytype").val(paytype);
        $("#payform").submit();
    }

</script>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</body>
</html>
