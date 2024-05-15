<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="container-fluid">
<%--    <jsp:include page="header1.jsp"></jsp:include>--%>
    <c:if test="${user.ismanage}">
        <jsp:include page="header_manage.jsp"></jsp:include>
    </c:if>
    <c:if test="${user.isadmin}">
        <jsp:include page="header1.jsp"></jsp:include>
    </c:if>
    <br><br>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/admingoods_edit?typeid=${user.admintype}" method="post">
<%--        <input type="hidden" name="id" value="${g.id}">--%>
<%--        <input type="hidden" name="cover" value="${g.cover}">--%>
<%--        <input type="hidden" name="image1" value="${g.image1}">--%>
<%--        <input type="hidden" name="image2" value="${g.image2}">--%>
<%--        <input type="hidden" name="type" value="${param.type}">--%>
        <div class="form-group">
            <label for="input_name7" class="col-sm-1 control-label">ID</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name7" name="id" value="${g.id}">ID号一般不建议更改
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="name" value="${g.name}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name1" class="col-sm-1 control-label">价格</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name1" name="price" value="${g.price}">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name2" class="col-sm-1 control-label">介绍</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name2" name="intro" value="${g.intro}">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name3" class="col-sm-1 control-label">库存</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name3" name="stock" value="${g.stock}">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name4" class="col-sm-1 control-label">封面图片</label>
            <div class="col-sm-6">
                <img src="${g.cover}" width="100" height="100">
                <input type="text" name="cover" id="input_name4" value="${g.cover}">请将图片上传到图床在此输入链接且图片一定要为正方形，否则显示会出错
            </div>
        </div>、
        <div class="form-group">
            <label for="input_name4" class="col-sm-1 control-label">详情图片1</label>
            <div class="col-sm-6">
                <img src="${g.image1}" width="100" height="100">
                <input type="text" name="image1" id="input_name5" value="${g.image1}">请将图片上传到图床在此输入链接且图片一定要为正方形，否则显示会出错
            </div>
        </div>
        <div class="form-group">
            <label for="input_name5" class="col-sm-1 control-label">详情图片2</label>
            <div class="col-sm-6">
                <img src="${g.image2}" width="100" height="100">
                <input type="text" name="image2" id="input_name6" value="${g.image2}">请将图片上传到图床在此输入链接且图片一定要为正方形，否则显示会出错
            </div>
        </div>
        <div class="form-group">
            <label for="select_topic" class="col-sm-1 control-label">类目</label>
            <div class="col-sm-6">
                <select class="form-control" id="select_topic" name="typeid">
                    <c:forEach items="${typeList}" var="t">
                        <option <c:if test="${t.id==g.type.id}">selected="selected"</c:if> value="${t.id}">${t.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="sumbit" class="btn btn-success">提交修改</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
