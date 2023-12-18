<%@ page import="model.User" %>
<%@ page import="service.OrderService" %>
<%@ page import="model.Order" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<%--<%@include file="header.jsp"%>--%>
<c:choose>
    <c:when test="${not empty user}">
        <jsp:include page="header_1.jsp"></jsp:include>

    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>
    </c:otherwise>
</c:choose>

<%--<c:if test="${empty user}"><%response.sendRedirect("/index");%></c:if>--%>
<%
    User u=(User)request.getSession().getAttribute("user");
    OrderService oService=new OrderService();
    if(u==null) {
        request.setAttribute("failMsg","你还未登录，请登陆后再查看！");
        request.getRequestDispatcher("user_login.jsp").forward(request,response);
    }
    List<Order> list=oService.selectAll(u.getId());
    request.getSession().setAttribute("orderlist",list);
%>
<div class="account">
    <div class="container">
        <div class="register">
            <c:if test="${!empty msg}">
                <div class="alert alert-success">${msg}</div>
            </c:if>
            <c:if test="${!empty failMsg}">
                <div class="alter alert-danger">${failMsg}</div>
            </c:if>
            <div class="register-top-grid">
                <h3>个人中心</h3>
                <form action="${pageContext.request.contextPath}/user_changeaddress" method="post">
                    <h4>收货信息</h4>
                    <div class="input">
                        <span>收货人<label></label></span>
                        <input type="text" name="name" value="${user.name}" placeholder="请输入收货人姓名">
                     </div>
                    <div class="input">
                        <span>收货电话</span>
                        <input type="text" name="phone" value="${user.phone}" placeholder="请输入收货电话">
                    </div>
                    <div class="input">
                        <span>收货地址</span>
                        <input type="text" name="address" value="${user.address}" placeholder="请输入收货地址">
                    </div>
                    <div class="register-but text-center">
                        <input type="submit" value="提交">
                    </div>
                </form>
                <form action="${pageContext.request.contextPath}/user_changepwd" method="post">
                    <h4>安全信息</h4>
                    <div class="input">
                        <span>原密码</span>
                        <input type="text" name="password" placeholder="请输入原密码">
                    </div>
                    <div class="input">
                        <span>新密码</span>
                        <input type="text" name="newPassword" placeholder="请输入新密码">
                    </div>
                    <div class="input">
                        <span>请再次输入新密码</span>
                        <input type="text" name="newPasswordagain" placeholder="请再次输入新密码">
                    </div>
                    <div class="clearfix"></div>
                    <div class="register-but text-center">
                        <input type="submit" value="提交">
                    </div>
                </form>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</body>
</html>
