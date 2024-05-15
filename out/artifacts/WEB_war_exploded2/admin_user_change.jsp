<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置登录口令</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container-fluid">
    <jsp:include page="header_manage.jsp"></jsp:include>

    <br>
    <br>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/adminuser_edit" method="post">
<%--        <div class="form-group">--%>
<%--            <label for="input_name7" class="col-sm-1 control-label">ID</label>--%>
<%--            <div class="col-sm-6">--%>
<%--                <input type="text" class="form-control" id="input_name7" name="id" value="${user.id}">ID号一般不建议更改--%>
<%--            </div>--%>
<%--        </div>--%>
    <br>
    <br>
    <br>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">登录名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="username" value="${user1.username}" required="required">
            </div>
        </div>
    <br>
    <br>
        <div class="form-group">
            <label for="input_name1" class="col-sm-1 control-label">登录邮箱</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name1" name="email" value="${user1.email}">
            </div>
        </div>
    <br>
    <br>
        <div class="form-group">
            <label for="input_name2" class="col-sm-1 control-label">登录密码</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name2" name="password" value="${user1.password}">
            </div>
        </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
            <button type="sumbit" class="btn btn-success">提交修改</button>
            <button type="reset" class="btn btn-danger">重置</button>
        </div>
<%--    </div>--%>
<%--        <div class="form-group">--%>
<%--            <div class="col-sm-offset-1 col-sm-10">--%>
<%--                --%>
<%--            </div>--%>
<%--        </div>--%>
    </form>
</div>
</body>
</html>
