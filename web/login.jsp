<%--
  Created by IntelliJ IDEA.
  User: 稀落的星
  Date: 2020/5/13
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>login</title>
    <!-- Bootstrap -->
    <link href="./css/bootstrap.min.css" rel="stylesheet"/>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="./js/jquery-2.1.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./js/bootstrap.min.js"></script>
    <script>
        window.onload = function () {
            document.getElementById('checkcode').onclick = function () {
                this.src = "${pageContext.request.contextPath}/checkCode?time=" + new Date().getTime();
            }
        }
    </script>
</head>
<body>
<div class="container" style="width: 400px">
    <h2 style="text-align: center">用户登录</h2>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/LoginServlet">
        <div class="form-group">
            <label for="userid">id</label>
            <input type="text" class="form-control" id="userid" placeholder="id" name="id">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
                   name="password">
        </div>
        <div class="form-group form-inline">
            <label for="exampleInputName2">验证码：</label>
            <input type="text" class="form-control" id="exampleInputName2" name="checkcode" placeholder="验证码">
            <img id="checkcode" src="${pageContext.request.contextPath}/checkCode" alt="验证码" title="看不清点击刷新"/>
        </div>
        <button type="submit" class="btn btn-primary center-block btn-lg" style="margin-top: 40px; ">登录
        </button>

    </form>
    <c:if test="${requestScope.checkcodeInfo!=null}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <strong>${requestScope.checkcodeInfo}</strong>
        </div>
    </c:if>
    <c:if test="${requestScope.loginInfo!=null}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <strong>${requestScope.loginInfo}</strong>
        </div>
    </c:if>
</div>

</body>
</html>
