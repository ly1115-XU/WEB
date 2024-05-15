<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览记录</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container-fluid">
    <jsp:include page="header1.jsp"></jsp:include>
    <br><br><br>
    <br>
    <br>
    <table class="table table-bordered table-hover" style="border: none;">
        <tr>
            <th style="text-align: center;" width="5%">ID</th>
            <th style="text-align: center;" width="10%">商品ID</th>
            <th style="text-align: center;" width="20%">商品照片</th>
            <th style="text-align: center;" width="10%">商品名称</th>
            <th style="text-align: center;" width="10%">商品种类</th>
            <th style="text-align: center;" width="20%">浏览量</th>

            <%--            <th width="10%">类目</th>--%>
        </tr>
        <c:forEach items="${ViewList}" var="vl">

            <tr>
                <td style="text-align: center;"><p>${vl.id}</p></td>
                <td style="text-align: center;"><p>${vl.goods.id}</p></td>
                <td style="text-align: center;">
                    <p><a href="${pageContext.request.contextPath}/goods_detail?id=${vl.goods.id}" target="_blank"><img src="${vl.goods.cover}" width="100px"></a></p>
                </td>
                <td style="text-align: center;">
                    <p><a href="${pageContext.request.contextPath}/goods_detail?id=${vl.goods.id}" target="_blank">${vl.goods.name}</a></p>
                </td>
<%--                <c:forEach items="${GoodsList}" var="t">--%>
<%--                    <C:if t="${vl.goodsid}">--%>
<%--                        <td>--%>
<%--                            <p><a href="${pageContext.request.contextPath}/goods_detail?id=${vl.goodsid}" target="_blank"><img src="${t.cover}" width="100px"></a></p>--%>
<%--                        </td>--%>
<%--                        <td>--%>
<%--                            <a href="${pageContext.request.contextPath}/goods_detail?id=${vl.goodsid}" target="_blank">${t.name}</a> </p>--%>
<%--                        </td>--%>
<%--                    </C:if>--%>
<%--                </c:forEach>--%>
                <td style="text-align: center;">
                    <p>${vl.type.name}</p>
<%--                    <p>${typename}</p>--%>
                </td>
                <td style="text-align: center;"><p>${vl.amount}</p></td>
<%--                <td>--%>
<%--                    <c:forEach items="${GoodsList}" var="t">&ndash;%&gt;--%>
<%--            &lt;%&ndash;                        <option value="${t.id}">${t.name}</option>&ndash;%&gt;--%>
<%--                        <c:if t="${vl.goodsid}">--%>
<%--                            <p><a href="${pageContext.request.contextPath}/goods_detail?id=${vl.goodsid}" target="_blank"><img src="${t.cover}" width="100px"></a></p>--%>
<%--                        </c:if>--%>
<%--                    </c:forEach>--%>
<%--                </td>--%>
<%--&lt;%&ndash;                <td><p><a href="${pageContext.request.contextPath}/goods_detail?id=${vl.goodsid}" target="_blank"><img src="${vl.cover}" width="100px"></a></p></td>&ndash;%&gt;--%>
<%--                <td><p><a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}" target="_blank">${g.name}</a> </p></td>--%>
<%--                <td><p>${g.intro}</p></td>--%>
<%--                <td><p>${g.price}</p></td>--%>
<%--                <td><p style="color: ${g.stock == 0 ? 'red' : 'black'}">${g.stock}</p></td>--%>
                    <%--                <td><p>${g.type.name}</p></td>--%>
<%--                <td>--%>
<%--                    <a class="btn btn-success" href="${pageContext.request.contextPath}/admingoods_editshow?id=${g.id}&type=${type}">修改</a>--%>
<%--                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/admingoods_delete?id=${g.id}&type=${type}">删除</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
