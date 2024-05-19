<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="header_manage.jsp"></jsp:include>
<br>
<br>
<br><br><br><br><br><br>

<div class="jumbotron">
    <div class="container">
        <div class="jumbotron">
            <h1>Weclome!</h1>
            <br><br>
            <p>欢迎来到后台管理，点击下面的按钮查看销售情况！</p>
            <br><br>
            <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/adminsale_stats?typeid=0" role="button">查看销售情况</a></p>
        </div>
    </div>
</div>

</body>
</html>
