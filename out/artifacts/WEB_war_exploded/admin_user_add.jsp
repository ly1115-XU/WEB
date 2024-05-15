<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加销售人员</title>
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
    <br>
    <br>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/adminuser_add" method="post" >
        <div class="form-group">
            <label class="col-sm-1 control-label">用户名</label><label style="color: red">*</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="username" name="username" required="required">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-1 control-label">密码</label><label style="color: red">*</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="password" name="password" required="required">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">邮箱</label><label style="color: red">*</label>
            <div class="col-sm-6">
                <input type="email" class="form-control" id="email" name="email"  required="required">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">姓名</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="name" name="name" >
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">电话号码</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="phone" name="phone">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">地址</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="address" name="address">
            </div>
        </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">种类</label>
                    <div class="col-sm-6">
        <%--                <input type="text" class="form-control" id="input_name8" name="typeid" required="required">--%>
                        <select class="form-control" id="select" name="admintype">
                            <c:forEach items="${typeList}" var="t">
                                <option value="${t.id}">${t.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="submit" class="btn btn-success">提交</button>
                <button type="reset" class="btn btn-success">重置</button>
            </div>
        </div>
    </form>


</div>

</body>
</html>
