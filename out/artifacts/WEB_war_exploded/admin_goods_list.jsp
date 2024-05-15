<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body>
<div class="container-fluid">
<%--    <c:if test="${user.ismanage}">--%>
        <jsp:include page="header1.jsp"></jsp:include>
<%--    </c:if>--%>

    <br><br><br>
    <br>
    <br>
    <div class="text-left"><a class="btn btn-warning" href="admin_goods_add.jsp">添加商品</a></div>
<%--    <br><br>--%>
<%--    <ul role="tablist" class="nav nav-tabs">--%>
<%--        <li <c:if test="${type==0}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admingoods_list">全部商品</a></li>--%>
<%--        <li <c:if test="${type==1}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admingoods_list?type=1">饼干</a></li>--%>
<%--        <li <c:if test="${type==2}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admingoods_list?type=2">蛋糕</a></li>--%>
<%--        <li <c:if test="${type==3}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admingoods_list?type=3">饮品</a></li>--%>
<%--        <li <c:if test="${type==4}">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admingoods_list?type=4">其他</a></li>--%>
<%--    </ul>--%>
    <br><br>
    <table class="table table-bordered table-hover">
        <tr>
            <th class="center-text" width="5%">ID</th>
            <th class="center-text" width="10%">图片</th>
            <th class="center-text" width="10%">名称</th>
            <th class="center-text" width="20%">介绍</th>
            <th class="center-text" width="10%">价格</th>
            <th class="center-text" width="10%">库存</th>
            <th class="center-text" width="10%">商品状态</th>
            <th class="center-text" width="10%">类目</th>
            <th class="center-text" width="25%">操作</th>
        </tr>
        <c:forEach items="${list}" var="g">

            <tr>
                <td class="center-text"><p>${g.id}</p></td>
                <td class="center-text"><p><a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}" target="_blank"> <img src="${g.cover}" width="100px"></a></p></td>
                <td class="center-text"><p><a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}" target="_blank"> ${g.name}</a></p></td>
                <td class="center-text"><p>${g.intro}</p></td>
                <td class="center-text"><p>${g.price}</p></td>
                <td class="center-text"><p style="color: ${g.stock == 0 ? 'red' : 'black'}">${g.stock}</p></td>
<%--                <td class="center-text">--%>
<%--                    <p>--%>
<%--                        <c:if test="${g.stock==0}">库存为0</c:if>--%>
<%--                        <c:if test="${g.stock<10}">库存不足</c:if>--%>
<%--                        <c:if test="${g.stock>=10}">库存充足</c:if>--%>
<%--                    </p>--%>
<%--                </td>--%>
<%--                <td><p>${g.type.name}</p></td>--%>
                <td class="center-text">
                    <p class="stock-status">
                        <c:if test="${g.stock==0}">
                            <span class="zero" style="color: red">库存为0</span>
                        </c:if>
                        <c:if test="${g.stock<=10 && g.stock>0}">
                            <span class="low" style="color: #eb9316">库存不足</span>
                        </c:if>
                        <c:if test="${g.stock>10}">
                            <span class="enough" >库存充足</span>
                        </c:if>
                    </p>
                </td>

                <td class="center-text">

                    <p>
                        <c:if test="${type_id==1}">饼干</c:if>
                        <c:if test="${type_id==2}">蛋糕</c:if>
                        <c:if test="${type_id==3}">饮品</c:if>
                        <c:if test="${type_id==4}">其他</c:if>
                    </p>

<%--                    </p>--%>
                </td>
                <td class="center-text">
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/admingoods_editshow?id=${g.id}&type=${type}">修改</a>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/admingoods_delete?id=${g.id}&type=${type}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
