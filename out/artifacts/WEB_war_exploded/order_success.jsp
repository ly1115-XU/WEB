<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付成功</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
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

<div class="cart-items">
    <div class="container">
        <c:if test="${!empty msg}">
            <div class="alert alert-success">${msg}</div>
        </c:if>
        <p><a class="btn btn-sucess" href="${pageContext.request.contextPath}/order_list">查看我的订单</a> </p>
    </div>
</div>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</body>
</html>
