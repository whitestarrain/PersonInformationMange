<%--
  Created by IntelliJ IDEA.
  User: 稀落的星
  Date: 2020/5/13
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生列表</title>
    <!-- Bootstrap -->
    <link href="./css/bootstrap.min.css" rel="stylesheet"/>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="./js/jquery-2.1.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./js/bootstrap.min.js"></script>
    <style>
        td, th {
            text-align: center;
        }
    </style>
</head>
<body class="container">
<div class="jumbotron">
    <h1>Hello,${sessionScope.loginInstructor.name} </h1>
</div>
<h2 style="text-align: center">学生列表</h2>
<table class="table table-hover table-bordered">
    <thead style="background-color: antiquewhite">
    <tr>
        <th><input type="checkbox" id="firstCb"></th>
        <th>序号</th>
        <th>name</th>
        <th>dept_name</th>
        <th>tot_cred</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.studentList}" var="studnet" varStatus="s">
        <tr>
            <td>
                <input type="checkbox" name="id" value="${studnet.id}">
            </td>
            <td>
                    ${s.count}
            </td>
            <td>
                    ${studnet.name}
            </td>
            <td>
                    ${studnet.deptName}
            </td>
            <td>
                    ${studnet.totCred}
            </td>
            <td>
                <button class="btn btn-default">修改</button>
                <button class="btn btn-default">删除</button>
            </td>
        </tr>

    </c:forEach>

    <tr>
        <td align="center" colspan="6">
            <button class="btn btn-primary" style="text-align: center">添加联系人</button>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>