<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加库存</title>
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
    <br>


    <jsp:include page="header_manage.jsp"></jsp:include>
    <br>

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
    <table class="table-container">
        <tr>
            <th class="center-text" width="300px" height="50px">商品ID</th>
            <td class="center-text" width="700px" height="50px">${g.id}</td>
        </tr>
        <tr>
            <th class="center-text" width="300px" height="50px">商品名称</th>
            <td class="center-text" width="700px" height="50px">${g.name}</td>
        </tr>
        <tr>
            <th class="center-text" width="300px" height="50px">商品种类</th>
            <td class="center-text" width="700px" height="50px">
                <c:if test="${g.type.id==1}"><p>饼干</p></c:if>
                <c:if test="${g.type.id==2}"><p>蛋糕</p></c:if>
                <c:if test="${g.type.id==3}"><p>饮品</p></c:if>
                <c:if test="${g.type.id==4}"><p>其他</p></c:if>
            </td>
        </tr>
        <tr>
            <th class="center-text" width="300px" height="120px">商品图片</th>
            <td class="center-text" width="700px" height="120px">
                <img src="${g.cover}" width="100px">
            </td>
        </tr>
        <tr>
            <th class="center-text" width="300px" height="50px">现有库存</th>
            <td class="center-text" width="700px" height="50px">
                <p>${g.stock}</p>
            </td>
        </tr>
        <tr>
            <th class="center-text" width="300px" height="100px"><p>要添加的库存</p></th>
<%--            <td class="center-text" width="10%">--%>
<%--                <form method="post" href="${pageContext.request.contextPath}/adminstock_add?goods_id=${g.id}">--%>
<%--                    <input name="stock" id="stock" placeholder="请输入要添加的库存" required="required">--%>
<%--                    <input type="submit" value="提交">--%>
<%--                    &nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--                    <input type="reset" value="重置">--%>
<%--                </form>--%>
<%--            </td>--%>
            <td class="center-text" width="700px" height="100px">
                <form action="${pageContext.request.contextPath}/adminstock_add" method="post">
                    <input type="text" name="goods_id" value="${g.id}" style="display: none;">
                    <input type="number" name="stock" id="stock" placeholder="请输入要添加的库存" required>
                    <input type="submit" value="提交">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="重置">
                </form>
            </td>

        </tr>
    </table>
</div>
</body>
</html>
