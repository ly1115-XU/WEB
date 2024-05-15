<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户画像</title>
    <!-- 引入WordCloud.js库 -->
    <!-- 引入 D3.js -->
    <script src="https://d3js.org/d3.v6.min.js"></script>
    <!-- 引入 WordCloud.js -->
    <script src="https://cdn.jsdelivr.net/npm/d3-cloud@1.2.5/build/d3.layout.cloud.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/wordcloud2.js/1.0.6/wordcloud2.min.js"></script>
    <script src="https://d3js.org/d3.v6.min.js"></script>
<%--    <script src="d3-cloud-master/build/d3.layout.cloud.js"></script>--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/d3-cloud/1.2.7/d3.layout.cloud.js"></script>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>

    <style>
        /* 设置大框的样式 */
        .container1 {
            display: flex; /* 使用 Flexbox 布局 */
            justify-content: space-between; /* 左右分布 */
            border: 1px solid #ccc; /* 添加边框 */
            padding: 20px; /* 添加内边距 */
        }

        /* 左侧表格的样式 */
        .table-container1 {
            flex: 1; /* 占据剩余空间 */
            margin-right: 20px; /* 右侧留出一些间距 */
        }

        /* 右侧词云的样式 */
        .word-cloud1 {
            flex: 1; /* 占据剩余空间 */
            background-color: #f0f0f0; /* 设置背景颜色 */
            padding: 10px; /* 添加内边距 */
        }

        /* 表格样式（示例） */
        table {
            width: 100%; /* 宽度100% */
            border-collapse: collapse; /* 边框合并 */
        }

        th, td {
            border: 1px solid #ddd; /* 添加边框 */
            padding: 8px; /* 添加内边距 */
            text-align: left; /* 左对齐 */
        }

        th {
            background-color: #f2f2f2; /* 表头背景色 */
        }
    </style>
</head>
<body>
<jsp:include page="header_manage.jsp"></jsp:include>
<c:forEach items="${userImpressionList}" var="impression">
<div class="container1">

        <!-- 左侧表格部分 -->
        <div class="table-container1">
            <h2>${impression.user_id}的用户画像</h2>
            <table>
                <thead>
                <tr>
                    <th>注册时间</th>
                    <th>活跃状态</th>
                    <th>消费水平</th>

                </tr>
                </thead>
                <tbody>

                <tr>
                    <td>${impression.register}</td>
                    <td>${impression.action}</td>
                    <td>${impression.cost}</td>
                    <!-- 更多数据列 -->
                </tr>
                </tbody>
            </table>
        </div>

        <!-- 右侧词云部分 -->
        <div class="word-cloud">
            <h2>词云</h2>
            <div id="wordcloud">
<%--                <a><img src="'images/wordcloud'+${impression.user_id}+'.png'" > </a>--%>
                <a><img src="images/wordcloud${impression.user_id}.png"></a>
            </div>
        </div>

</div>

</c:forEach>
<%--<div id="wordcloud"></div>--%>



</body>


</html>
