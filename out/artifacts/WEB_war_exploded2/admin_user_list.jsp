<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户表</title>
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
<%--    <jsp:include page="header1.jsp"></jsp:include>--%>
<%--    <c:if test="${user.ismanage}">--%>
<%--        <jsp:include page="header_manage.jsp"></jsp:include>--%>
<%--    </c:if>--%>
<%--    <c:if test="${user.isadmin}">--%>
<%--        <jsp:include page="header1.jsp"></jsp:include>--%>
<%--    </c:if>--%>
<%--    <br/>--%>
<%--    <br/>--%>
<%--    <br/>--%>
            <jsp:include page="header_manage.jsp"></jsp:include>
<%--    <div class="text-right"><a class="btn btn-warning" href="admin_user_add.jsp">添加用户</a> </div>--%>
    <c:if test="${!empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${!empty failMsg}">
        <div class="alert alert-danger">${failMsg}</div>
    </c:if>
    <br>
    <br>
    <br>
    <br/>
    <div class="text-left"><a class="btn btn-warning" href="admin_user_add.jsp">添加销售人员</a></div>
    <br>
    <br>
    <br>
    <table class="table table-bordered table-hover">
        <tr>
            <th class="center-text" width="5%">ID</th>
            <th class="center-text" width="10%">用户名</th>
            <th class="center-text" width="10%">邮箱</th>
            <th class="center-text" width="10%">收件人</th>
            <th class="center-text" width="10%">电话</th>
            <th class="center-text" width="10%">地址</th>
            <th class="center-text" width="10%">管理商品种类</th>
            <th class="center-text" width="10%">操作</th>
        </tr>
        <c:forEach items="${list}" var="u">
            <tr>
                <td class="center-text"><p>${u.id}</p></td>
                <td class="center-text"><p>${u.username}</p></td>
                <td class="center-text"><p>${u.email}</p></td>
                <td class="center-text"><p>${u.name}</p></td>
                <td class="center-text"><p>${u.phone}</p></td>
                <td class="center-text"><p>${u.address}</p></td>
                <td class="center-text">
                    <c:if test="${u.admintype==1}"><p>饼干</p></c:if>
                    <c:if test="${u.admintype==2}"><p>蛋糕</p></c:if>
                    <c:if test="${u.admintype==3}"><p>饮品</p></c:if>
                    <c:if test="${u.admintype==4}"><p>其他</p></c:if>
                </td>
                <td class="center-text">
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/adminuser_change?id=${u.id}">更改</a>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/adminuser_delete?id=${u.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
