<%@ page import="service.GoodsService" %>
<%@ page import="model.Goods" %><%--<jsp:useBean id="g" scope="request" type="model.Goods"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详情</title>
    <meta name="Viewport" content="width=device-width,inital-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/flexslider.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <script type="text/javascript" src="js/layer.js"></script>
    <script>
        $(function (){
            $('.flexslider').flexslider({
                animation:"slide",
                controlNav:"thumbnails"

            });
        });
    </script>
</head>
<body>
<c:choose>
    <c:when test="${not empty user}">

        <c:choose>
            <c:when test="${user.isadmin}">
                <jsp:include page="header1.jsp"></jsp:include>
            </c:when>
            <c:otherwise>
                <jsp:include page="header_1.jsp"></jsp:include>
            </c:otherwise>
        </c:choose>

    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>

    </c:otherwise>
</c:choose>

<%--<div class="single">--%>
<%--    <div class="container">--%>
<%--        <div class="col-md-4 single-grid">--%>
<%--            <div class="flexslider">--%>
<%--                <ul class="slides">--%>
<%--                    <li data-thumb="${g.cover}">--%>
<%--                        <div class="thumb-image">--%>
<%--                            <img src="${g.cover}" data-imagezoom="true" class="img-responsive">--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                    <li data-thumb="${g.image1}">--%>
<%--                        <div class="thumb-image">--%>
<%--                            <img src="${g.image1}" data-imagezoom="true" class="img-responsive">--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <div class="thumb-image">--%>
<%--                            <img src="${g.image2}" data-imagezoom="true" class="img-responsive">--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="col-md-4 single-grid simpleCart_shelfItem">--%>
<%--                <h3>${g.name}</h3>--%>
<%--                <div class="tag">--%>
<%--                    <p>分类：<a href="goods_list?typeid=${g.type.id}">${g.type.name}</a></p>--%>
<%--                </div>--%>
<%--                <p>${g.name}</p>--%>
<%--                <div class="galry">--%>
<%--                    <div class="prices">--%>
<%--                        <h5 class="item_price">￥ ${g.price}</h5>--%>
<%--                    </div>--%>
<%--                    <div class="clearfix"></div>--%>
<%--                </div>--%>
<%--                <div class="btn_form">--%>
<%--                    <a href="javascript:;" class="add-cart item_add" onclick="buy(${g.id})">加入购物车</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-md-4 single-grid1">--%>
<%--                <ul>--%>
<%--                    <li><a href="${pageContext.request.contextPath}/goods_list"></a></li>--%>
<%--                    <c:forEach items="${typeList}" var="t">--%>
<%--                        <li><a href="${pageContext.request.contextPath}/goods_list?typeid=${t.id}">${t.name}</a></li>--%>
<%--                    </c:forEach>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="clearfix"></div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<%--%>
<%--    GoodsService gService = new GoodsService();--%>
<%--    Goods g=gService.getGoodsById(request.getParameter('id'));--%>
<%--%>--%>


<div class="single">
    <div class="container">
        <div class="single-grids">
            <div class="col-md-4 single-grid">
                <div class="flexslider">

                    <ul class="slides">
<%--                        <li >--%>
<%--&lt;%&ndash;                            data-thumb="${g.cover}"&ndash;%&gt;--%>
<%--                            <div class="thumb-image">--%>
<%--                                <img src="${g.cover}" data-imagezoom="true" class="img-responsive">--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                        <li >--%>
<%--&lt;%&ndash;                            data-thumb="${g.image1}"&ndash;%&gt;--%>
<%--                            <div class="thumb-image">--%>
<%--                                <img src="${g.image1}" data-imagezoom="true" class="img-responsive">--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                        <li >--%>
<%--&lt;%&ndash;                            data-thumb="${g.image2}"&ndash;%&gt;--%>
<%--                            <div class="thumb-image">--%>
<%--                                <img src="${g.image2}" data-imagezoom="true" class="img-responsive">--%>
<%--                            </div>--%>
<%--                        </li>--%>
                        <img src="${g.cover}" data-imagezoom="true" class="img-responsive">
                    </ul>
                    <div class="img-container">
                        <img src="${g.image1}" data-imagezoom="true" class="img-responsive">
                    </div>
                    <div class="img-container">
                        <img src="${g.image2}" data-imagezoom="true" class="img-responsive">
                    </div>
                </div>
            </div>
            <div class="col-md-4 single-grid simpleCart_shelfItem">
                <h3>${g.name}</h3>
                <div class="tag">
                    <p>分类 : <a href="goods_list?typeid=${g.type.id}">${g.type.name}</a></p>
                </div>
                <p>${g.intro}</p>
                <div class="galry">
                    <div class="prices">
                        <h5 class="item_price">¥ ${g.price}</h5>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="btn_form">
                    <a href="javascript:;" class="add-cart item_add" onclick="buy(${g.id})">加入购物车</a>
                </div>
            </div>
            <div class="col-md-4 single-grid1">
                <!-- <h2>商品分类</h2> -->
                <ul>
<%--                    <li><a  href="/goods_list">全部系列</a></li>--%>

                    <c:forEach items="${typeList}" var="t">
                        <li><a href="${pageContext.request.contextPath}/goods_list?typeid=${t.id}">${t.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</body>
</html>
