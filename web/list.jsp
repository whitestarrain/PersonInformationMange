<%@ page import="domain.Instructor" %><%--
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
    <script>
        function deleteStudent(id) {
            if (confirm("确定要删除吗")) {
                location.href = "${pageContext.request.contextPath}/DeleteServlet?id=" + id
            }
        }

        window.onload = function () {
            var selectedform = document.getElementById("selected");
            var delSelected = document.getElementById("delSelected");
            delSelected.onclick = function () {
                if (confirm("确定要删除选中条目吗")) {
                    var flag = false
                    var sids = document.getElementsByName("sid");
                    for (var i = 0; i < sids.length; i++) {
                        if (sids[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    //有被选中的条目，提交
                    if (flag) {
                        selectedform.submit();
                    }
                }
            }

            var firstCb = document.getElementById("firstCb");
            firstCb.onclick = function () {
                var sids = document.getElementsByName("sid");
                for (var i = 0; i < sids.length; i++) {
                    sids[i].checked = firstCb.checked;
                }

            }
        }
    </script>
</head>
<body class="container">
<div class="jumbotron">
    <h1>Hello,${sessionScope.loginInstructor.name} </h1>
</div>
<h2 style="text-align: center">学生列表</h2>
<form class="form-inline">
    <div class="form-group">
        <label for="exampleInputName2">姓名</label>
        <input type="text" class="form-control" id="exampleInputName2" placeholder="姓名" name="name">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail2">专业</label>
        <input type="text" class="form-control" id="exampleInputEmail2" placeholder="deptName">
    </div>
    <div class="form-group">
        <label for="exampleInputName3">学分</label>
        <input type="text" class="form-control" id="exampleInputName3" placeholder="学分" name="totCred">
    </div>
    <button type="submit" class="btn btn-default">查询</button>
    <div class="form-group" style="float: right;margin-right: 5px;">
        <a class="btn btn-primary" style="text-align: center"
           href="${pageContext.request.contextPath}/add.jsp">添加学生</a>
        <%--        复习：禁止标签默认行为--%>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>
</form>

<form id="selected" method="post" action="${pageContext.request.contextPath}/DeleteSelectedServlet">
    <table class="table table-hover table-bordered" id="table">
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
                    <input type="checkbox" name="sid" value="${studnet.id}">
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
                    <a class="btn btn-default"
                       href="${pageContext.request.contextPath}/FindStudentServlet?id=${studnet.id}">修改</a>
                    <a class="btn btn-default" href="javascript:deleteStudent(${studnet.id})">删除</a>
                </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</form>
</body>
</html>
