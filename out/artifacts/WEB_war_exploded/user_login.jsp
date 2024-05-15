
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style1.css">


</head>
<body>
<%@include file="header.jsp"%>
<div class="accout">
    <div class="container">
        <div class="register">
            <c:if test="${!empty msg }">
                <div class="alert alert-danger">${msg}</div>
            </c:if>
            <c:if test="${!empty failMsg}">
                <div class="alert alert-danger">${failMsg}</div>
            </c:if>
            <form action="${pageContext.request.contextPath}/user_login" method="post">
                <br><br>
                <h1 style="text-align: center;color: #5e5e5e">登录</h1>
                <br><br><br><br><br><br><br>
                <div class="input text-center">
                    <span>用户名/邮箱<label style="color: red">*</label></span><br>
                    <input type="text" name="ue" style="width: 500px" placeholder="请输入用户名或邮箱" required="required">
                </div>
                <br><br><br><br>
                <div class="input text-center">
                    <span>密码<label style="color: red">*</label></span><br>
                    <input type="password" name="password" style="width: 500px" placeholder="请输入密码" required="required">
                </div>
                <br><br><br><br><br><br><br><br>
<%--                <div class="clearfix"> </div>--%>
                <div class="register-but text-center">
                    <input type="submit" value="提交">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="重置">
                </div>
            </form>
<%--            <div class="clearfix"></div>--%>
        </div>
    </div>
</div>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</body>
</html>
