<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品销售统计</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container-fluid">
    <jsp:include page="header_manage.jsp"></jsp:include>
    <br>
    <c:if test="${!empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${!empty failMsg}">
        <div class="alert alert-danger">${failMsg}</div>
    </c:if>
    <br>
    <ul role="tablist" class="nav nav-tabs">
        <li <c:if test="${type==0}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminsale_stats?typeid=0">全部商品</a></li>
        <li <c:if test="${type==1}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminsale_stats?typeid=1">饼干</a></li>
        <li <c:if test="${type==2}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminsale_stats?typeid=2">蛋糕</a></li>
        <li <c:if test="${type==3}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminsale_stats?typeid=3">饮品</a></li>
        <li <c:if test="${type==4}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/adminsale_stats?typeid=4">其他</a></li>
    </ul>
    <br><br>
    <table class="table table-bordered table-hover">
        <tr>
            <th class="center-text" width="5%">商品ID</th>
            <th class="center-text" width="8%">商品名</th>
            <th class="center-text" width="10%">商品照片</th>
            <th class="center-text" width="8%">商品种类</th>
            <th class="center-text" width="5%">库存</th>
            <th class="center-text" width="8%">销售状态</th>
            <th class="center-text" width="5%">售出数量</th>
            <th class="center-text" width="5%">操作</th>
        </tr>

        <c:forEach items="${ssList}" var="ss">
        <tr>
            <td class="center-text"><p>${ss.goodsid}</p></td>
<%--                                    href="${pageContext.request.contextPath}/goods_detail?id=${ss.goodsid}"--%>
            <td class="center-text"><p>${ss.name}</p></td>
            <td class="center-text"><img src="${ss.cover}" width="100px"> </td>
            <td class="center-text">
                <c:if test="${ss.typeid==1}">饼干</c:if>
                <c:if test="${ss.typeid==2}">蛋糕</c:if>
                <c:if test="${ss.typeid==3}">饮料</c:if>
                <c:if test="${ss.typeid==4}">其他</c:if>
            </td>
            <td class="center-text">${ss.stock}</td>
            <td class="center-text">
                <c:if test="${ss.stock==0}">
                    <span class="zero" style="color: red">售空</span>
                </c:if>
                <c:if test="${ss.stock>20}">
                    <span class="enough" >在售--库存充足</span>
                </c:if>
                <c:if test="${ss.stock>0 && ss.stock<=20}">
                    <span class="low" style="color: #eb9316">在售--库存不足</span>
                </c:if>
                <%--                        <c:if test="${gs.typeid==4}">其他</c:if>--%>
            </td>
            <td class="center-text"><p>${ss.amount}</p></td>
            <td class="center-text"><a class="btn btn-success" href="${pageContext.request.contextPath}/admingoods_detail?goodsid=${ss.goodsid}">库存管理</a> </td>
        </tr>
        </c:forEach>
</div>
</body>
</html>
