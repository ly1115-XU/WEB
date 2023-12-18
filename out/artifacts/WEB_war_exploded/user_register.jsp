
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="js/jquery-3.7.1.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
    <script src="js/bootstrap.js"></script>
<%--    <script src="js/bootstrap.min.js"></script>--%>
<%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>


    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>注册</title>
</head>
<body>
<%@include file="header.jsp"%>
   <div class="account" >
       <div class="container">
           <div class="register">
               <c:if test="${!empty msg}">
                   <div class="alert alert-danger" role="alert">${msg}</div>
               </c:if>
               <br><br>
               <form action="${pageContext.request.contextPath}/user_register" method="post" >
                   <div class="register-top-grid">
                       <h1 style="text-align: center;color: #5e5e5e">注册</h1>
                       <br><br><br>
                       <div class="input text-center">
                           <span >用户名<label style="color: red">*</label></span><br>
                           <input type="text" style="width: 500px;" name="username" placeholder="请输入用户名" required="required">
                       </div>
                       <br><br>
                       <div class="input text-center">
                           <span >密码<label style="color: red">*</label></span><br>
                           <input type="password" style="width: 500px;" name="password" placeholder="请输入密码" required="required">
                       </div>
                       <br><br>
                       <div class="input text-center">
                           <span style="color: #9d9d9d">邮箱<label style="color: red">*</label></span><br>
                           <input type="email" style="width: 500px; " name="email" placeholder="请输入邮箱地址" required="required">
                       </div>
                       <br><br>
                       <div class="input text-center">
                           <span style="color: #9d9d9d">收货人</span><br>
                           <input type="text" style="width: 500px;" name="name" placeholder="请输入收货人">
                       </div>
                       <br><br>
                       <div class="input text-center">
                           <span style="color: #9d9d9d">收货电话</span><br>
                           <input type="text" style="width: 500px;" name="phone" placeholder="请输入收货电话">
                       </div>
                       <br><br>
                       <div class="input text-center">
                           <span >收货地址</span><br>
                           <input type="text" style="width: 500px; " name="address" placeholder="请输入收货地址">
                       </div>
                       <br><br><br>
                       <div class="register-but text-center">
                           <input type="submit" value="提交">
                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           <input type="reset" value="重置">
                       </div>
                   </div>
               </form>
           </div>

       </div>

   </div>
</body>
<%--<jsp:include page="/footer.jsp"></jsp:include>--%>
</html>
