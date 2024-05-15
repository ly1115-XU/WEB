<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品添加</title>
<%--    <link rel="stylesheet" href="css/bootstrap.css">--%>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container-fluid">


    <jsp:include page="header1.jsp"></jsp:include>

    <br><br>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/admingoods_add" method="post" >
        <div class="form-group">
            <label class="col-sm-1 control-label">名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="name" name="name" required="required">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-1 control-label">价格</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_" name="price" required="required">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">介绍</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name3" name="intro" >
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">库存</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name4" name="stock" required="required">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">封面</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name5" name="cover" required="required">请将图片上传到图床在此输入链接且图片一定要为正方形，否则显示会出错
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">详情1</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name6" name="image1" required="required">请将图片上传到图床在此输入链接且图片一定要为正方形，否则显示会出错
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">详情2</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name7" name="image2" required="required">请将图片上传到图床在此输入链接且图片一定要为正方形，否则显示会出错
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="submit" class="btn btn-success">提交</button>
                <button type="reset" class="btn btn-success">重置</button>
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label class="col-sm-1 control-label">种类</label>--%>
<%--            <div class="col-sm-6">--%>
<%--&lt;%&ndash;                <input type="text" class="form-control" id="input_name8" name="typeid" required="required">&ndash;%&gt;--%>
<%--                <select class="form-control" id="select" name="typeid">--%>
<%--                    <c:forEach items="${typeList}" var="t">--%>
<%--                        <option value="${t.id}">${t.name}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--        </div>--%>

    </form>
</div>
</body>
</html>
