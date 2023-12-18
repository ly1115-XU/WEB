<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售统计</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
</head>
<body>

<div class="container-fluid">
    <jsp:include page="header1.jsp"></jsp:include>
    <ul role="tablist" class="nav nav-tabs">
        <li <c:if test="${type==0}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminorderitems">全部商品</a></li>
        <li <c:if test="${type==1}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminorderitems?type=1">饼干</a></li>
        <li <c:if test="${type==2}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminorderitems?type=2">蛋糕</a></li>
        <li <c:if test="${type==3}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminorderitems?type=3">饮品</a></li>
        <li <c:if test="${type==4}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminorderitems?type=4">其他</a></li>
    </ul>
    <table class="table table-bordered table-hover">
        <tr>
            <th width="5%">ID</th>
            <th width="5%">商品ID</th>
<%--            <th width="5%">订单ID</th>--%>
            <th width="10%">单个价格</th>
            <th width="10%">一次售出数量</th>
            <th width="10%">该商品一次售出的总价</th>
            <th width="5%">种类</th>
        </tr>
<%--        <%--%>
<%--           List<OrderItem> list= (List< OrderItem >.of(request.getParameter("list"));--%>

<%--           System.out.println(list);--%>
<%--        %>--%>
<%--        <jsp:useBean id="oilist" scope="request" />--%>
<%--        <c:out value="${oilist}" />--%>
        <c:forEach items="${oilist}" var="oi">
<%--            <c:out value="${oi.id}"></c:out>--%>
            <tr>
                <td><p>${oi.id}</p></td>

                <td><a style="color: cornflowerblue" href="${pageContext.request.contextPath}/goods_detail?id=${oi.goods_id}">${oi.goods_id}</a></td>
<%--&lt;%&ndash;                <td><p>${oi.order_id}</p></td>&ndash;%&gt;--%>
                <td><p>${oi.price}</p></td>
                <td><p>${oi.amount}</p></td>

<%--                <c:when test="${not empty oi.amount and not empty oi.price}">--%>
                    <td><p>${oi.amount * oi.price}</p></td>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <td><p>N/A</p></td> <!-- 或者其他处理方式 -->--%>
<%--                </c:otherwise>--%>
                <td>
                    <p>
                        <c:if test="${oi.type_id==1}">饼干</c:if>
                        <c:if test="${oi.type_id==2}">蛋糕</c:if>
                        <c:if test="${oi.type_id==3}">饮品</c:if>
                        <c:if test="${oi.type_id==4}">其他</c:if>
                    </p>
                </td>
            </tr>
        </c:forEach>
        <hr>
<%--        <p>总数量：${totalamount}&nbsp;&nbsp;&nbsp;总价格：${totalamount}</p>--%>
    </table>
</div>


</body>
</html>
