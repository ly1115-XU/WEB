<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品售卖情况</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<jsp:include page="header_manage.jsp"></jsp:include>
<br>
<br>
<br>
<div class="container-fluid">
    <br>
    <br>
    <table class="table table-bordered table-hover">
        <tr>
            <th class="center-text" width="5%">商品ID</th>
            <th class="center-text" width="10%">商品名</th>
            <th class="center-text" width="10%">商品照片</th>
            <th class="center-text" width="8%">商品种类</th>
<%--            <th class="center-text" width="5%">库存</th>--%>
<%--            <th class="center-text" width="8%">销售状态</th>--%>
            <th class="center-text" width="5%">售出数量</th>
        </tr>

            <c:forEach items="${gsList}" var="gs">
                <tr>
                    <td class="center-text"><p>${gs.goodsid}</p></td>
<%--                    href="${pageContext.request.contextPath}/goods_detail?id=${gs.goodsid}"--%>
                    <td class="center-text"><p>${gs.name}</p></td>
                    <td class="center-text"><img src="${gs.cover}" width="100px"> </td>
                    <td class="center-text">
                        <c:if test="${gs.typeid==1}">饼干</c:if>
                        <c:if test="${gs.typeid==2}">蛋糕</c:if>
                        <c:if test="${gs.typeid==3}">饮料</c:if>
                        <c:if test="${gs.typeid==4}">其他</c:if>
                    </td>
<%--                    <td class="center-text">${gs.stock}</td>--%>
<%--                    <td class="center-text">--%>
<%--                        <c:if test="${gs.stock==0}">--%>
<%--                            <span class="zero" style="color: red">售空</span>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${gs.stock>20}">--%>
<%--                            <span class="enough" >在售--库存充足</span>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${gs.stock>0 && gs.stock<=20}">--%>
<%--                            <span class="low" style="color: #eb9316">在售--库存不足</span>--%>
<%--                        </c:if>--%>
<%--&lt;%&ndash;                        <c:if test="${gs.typeid==4}">其他</c:if>&ndash;%&gt;--%>
<%--                    </td>--%>
                    <td class="center-text"><p>${gs.amount}</p></td>
                </tr>
            </c:forEach>

    </table>
</div>
</body>
</html>
