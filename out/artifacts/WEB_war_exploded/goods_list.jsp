<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表</title>
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
<%--<jsp:include page="index.jsp">--%>
<%--    --%>
<%--</jsp:include>--%>

<%--<%@include file="header.jsp"%>--%>
<c:choose>
    <c:when test="${not empty user}">
        <jsp:include page="header_1.jsp"></jsp:include>

    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>
    </c:otherwise>
</c:choose>
<%--<div class="products">--%>
<%--    <div class="container">--%>
<%--        <div class="col-md-12 product-model-sec">--%>
<%--            <c:forEach items="${p.list}" var="g">--%>
<%--                <div class="product-grid" style="width: 255px;border: 2px solid #C7C7C7; border-radius: 5px;">--%>
<%--&lt;%&ndash;                    <div class="product-grid">&ndash;%&gt;--%>
<%--                        <a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}">--%>
<%--                            <div class="more-product"><span> </span></div>--%>
<%--                            <div class="prduct-img b-link-stripe b-animate-go thickbox">--%>
<%--&lt;%&ndash;                                <img src="${g.cover}" class="img-responsive" alt="${g.name}"style="width:250px;height:250px" >&ndash;%&gt;--%>
<%--                                    <img src="${g.cover}" class="card-img-top" style="width: 250px;height: 250px" alt="...">--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <img src="https://www.bigbigwork.com/tupian/image/20975179107.html" class="card-img-top" style="width: 200px;height: 200px" alt="...">&ndash;%&gt;--%>
<%--                    <div class="card-body">--%>
<%--                        <h4 class="card-title">${g.name}</h4>--%>
<%--                        <h5 class="card-title" style="color: #dca7a7">￥ ${g.price}</h5>--%>
<%--                        <p class="card-text">${g.intro}</p>--%>
<%--&lt;%&ndash;                        <a href="#" class="btn btn-primary">加入购物车</a>&ndash;%&gt;--%>
<%--                        <input type="button" class="item_add items" value="加入购物车" onclick="buy(${g.id})">--%>
<%--                    </div>--%>
<%--                </div>--%>



<%--            </c:forEach>--%>

<%--        </div>--%>
<%--        <jsp:include page="page.jsp">--%>
<%--            <jsp:param name="url" value="/goods_list"/>--%>
<%--            <jsp:param name="param" value="&typeid=${id}"/>--%>
<%--        </jsp:include>--%>

<%--    </div>--%>
<%--</div>--%>
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
            <c:forEach items="${list}" var="g">
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
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
