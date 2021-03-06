<%--
  Created by IntelliJ IDEA.
  User: 稀落的星
  Date: 2020/5/13
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加学生</title>
    <!-- Bootstrap -->
    <link href="./css/bootstrap.min.css" rel="stylesheet"/>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="./js/jquery-2.1.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#exampleInputEmail1").blur(function () {
                var val=$(this).val();
                $.get("CheckIdServlet",{"id":val},function (data) {
                    $("#info").text(data.info);
                    if(data.isExsit){
                        $("#submitbut").attr("disabled",true);
                    }else{
                        $("#submitbut").attr("disabled",false);
                    }
                },"json");
            })
        })
    </script>
</head>
<body>
<div class="container" style="width: 500px">
    <h2 style="text-align: center">添加学生</h2>
    <form action="${pageContext.request.contextPath}/addServlet" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">id</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="id" name="id">
            <label id="info" class="label-warning"></label>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword3">姓名</label>
            <input type="text" class="form-control" id="exampleInputPassword3" placeholder="name" name="name">
        </div>
        <div class="form-group">
            <label for="exampleInputPasswor1">专业名称</label>
            <input type="text" class="form-control" id="exampleInputPasswor1" placeholder="profession" name="deptName" >
        </div>
        <div class="form-group">
            <label for="exampleInputPasswrd1">学分</label>
            <input type="text" class="form-control" id="exampleInputPasswrd1" placeholder="学分" name="totCred">
        </div>
        <div style="text-align: center">
            <button type="submit" class="btn btn-primary" id="submitbut">提交</button>
            <button type="reset" class="btn btn-default">重置</button>
            <button type="button" id="back" class="btn btn-default">返回</button>
        </div>
    </form>
</div>
<script>
    document.getElementById('back').onclick=function(){
        window.history.back();
    }
</script>
</body>
</html>
