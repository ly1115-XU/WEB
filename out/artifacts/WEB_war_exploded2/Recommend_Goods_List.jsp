<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>猜你喜欢</title>
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
<jsp:include page="header_1.jsp"></jsp:include>
<div class="products">
    <c:if test="${!empty failMsg}">
        <div class="alert alert-danger">${failMsg}</div>
        <%
            request.getSession().removeAttribute("failMsg");
        %>
    </c:if>
    <div class="container">
        <%--        <h2><c:choose><c:when test="${empty t}">全部系列</c:when><c:otherwise>${t.name}</c:otherwise> </c:choose></h2>--%>

        <div class=" product-model-sec">
            <%--            col-md-12--%>
            <c:forEach items="${RecommendGoodsList}" var="g">
                <%--                展示商品--%>
                <%--                begin="${empty param.pageNumber ? 0 : (param.pageNumber-1)*8}"--%>


                <div class="product-grid">
                        <%--                    class="product-grid"--%>
                    <a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}">
                        <div class="more-product"><span> </span></div>
                        <div class="product-img b-link-stripe b-animate-go  thickbox">
                            <img src="${g.cover}" class="img-responsive" alt="${g.name}" width="240" height="240">
                            <div class="b-wrapper">
                                <h4 class="b-animate b-from-left  b-delay03">
                                    <button href="${pageContext.request.contextPath}/goods_detail?id=${g.id}">查看详情</button>
                                </h4>
                            </div>
                        </div>
                    </a>
                    <div class="product-info simpleCart_shelfItem">
                        <div class="product-info-cust prt_name">
                            <h4>${g.name}</h4>
                            <span class="item_price">¥ ${g.price}</span>
                            <input type="button" class="item_add items" value="加入购物车" onclick="buy(${g.id})">
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>

        <%--        <jsp:include page="page.jsp">--%>
        <%--            <jsp:param name="url" value="${pageContext.request.contextPath}/goods_list"></jsp:param>--%>
        <%--            <jsp:param name="param" value="&typeid=${id}"></jsp:param>--%>
        <%--        </jsp:include>--%>
    </div>
</div>
</body>
</html>
