<%@ page import="model.Sale" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售业绩</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<jsp:include page="header_manage.jsp"></jsp:include>
<div class="container-fluid">
    <br><br><br><br>
    <table class="table table-bordered table-hover">
        <tr>
            <th class="center-text" width="5%">销售人员ID</th>
            <th class="center-text" width="15%">销售人员用户名</th>
            <th class="center-text" width="15%">销售种类</th>
            <th class="center-text" width="10%">销售数量</th>

        </tr>
<%--        <%--%>
<%--           List<Sale> saleList= (List)request.getSession().getAttribute("saleList");--%>
<%--           System.out.println(saleList);--%>
<%--        %>--%>
        <c:forEach items="${saleList}" var="sale">
            <tr>
                <td class="center-text"><p>${sale.user.id}</p></td>
                <td class="center-text"><a href="${pageContext.request.contextPath}/admingoods_sale?typeid=${sale.user.admintype}">${sale.user.username}</a></td>
                <td class="center-text">
                    <a href="${pageContext.request.contextPath}/admingoods_sale?typeid=${sale.user.admintype}">
                        <c:if test="${sale.user.admintype==1}">饼干</c:if>
                        <c:if test="${sale.user.admintype==2}">蛋糕</c:if>
                        <c:if test="${sale.user.admintype==3}">饮料</c:if>
                        <c:if test="${sale.user.admintype==4}">其他</c:if>
                    </a>
                </td>
                <td class="center-text">
                   <p>${sale.amount}</p>
                </td>

            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
