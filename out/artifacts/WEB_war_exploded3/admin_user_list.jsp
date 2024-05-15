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
    <jsp:include page="header1.jsp"></jsp:include>
<%--    <br/>--%>
<%--    <br/>--%>
<%--    <br/>--%>
<%--    <div class="text-right"><a class="btn btn-warning" href="admin_user_add.jsp">添加用户</a> </div>--%>
    <c:if test="${!empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${!empty failMsg}">
        <div class="alert alert-danger">${failMsg}</div>
    </c:if>
    <br/><br/>
    <table class="table table-bordered table-hover">
        <tr>
            <th width="5%">ID</th>
            <th width="10%">用户名</th>
            <th width="10%">邮箱</th>
            <th width="10%">收件人</th>
            <th width="10%">电话</th>
            <th width="10%">地址</th>
            <th width="10%">操作</th>
        </tr>
        <c:forEach items="${list}" var="u">
            <tr>
                <td><p>${u.id}</p></td>
                <td><p>${u.username}</p></td>
                <td><p>${u.email}</p></td>
                <td><p>${u.name}</p></td>
                <td><p>${u.phone}</p></td>
                <td><p>${u.address}</p></td>
                <td>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/adminuser_delete?id=${u.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
