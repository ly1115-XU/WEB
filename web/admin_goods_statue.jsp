<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售状态</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container-fluid">
<%--    <jsp:include page="header1.jsp"></jsp:include>--%>
    <c:if test="${user.ismanage}">
        <jsp:include page="header_manage.jsp"></jsp:include>
    </c:if>
    <c:if test="${user.isadmin}">
        <jsp:include page="header1.jsp"></jsp:include>
    </c:if>
    <br><br><br/>
    <table class="table table-bordered table-hover">
        <tr>
            <th width="5%">ID</th>
            <th width="10%">图片</th>
            <th width="10%">名称</th>
            <th width="20%">介绍</th>
            <th width="10%">价格</th>
            <th width="10%">库存</th>
            <th width="10%">类目</th>
            <th width="25%">操作</th>
        </tr>
        <c:forEach items="${list}" var="g">

            <tr>
                <td><p>${g.id}</p></td>
                <td><p><a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}" target="_blank"><img src="${g.cover}" width="100px"></a></p></td>
                <td><p><a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}" target="_blank">${g.name}</a> </p></td>
                <td><p>${g.intro}</p></td>
                <td><p>${g.price}</p></td>
                <td><p style="color: ${g.stock == 0 ? 'red' : 'black'}">${g.stock}</p></td>
                    <%--                <td><p>${g.type.name}</p></td>--%>
                <td>

                    <p>
                        <c:if test="${type_id==1}">饼干</c:if>
                        <c:if test="${type_id==2}">蛋糕</c:if>
                        <c:if test="${type_id==3}">饮品</c:if>
                        <c:if test="${type_id==4}">其他</c:if>
                    </p>

                        <%--                    </p>--%>
                </td>
                <td>
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/admingoods_editshow?id=${g.id}&type=${type}">修改</a>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/admingoods_delete?id=${g.id}&type=${type}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
