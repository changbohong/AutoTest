<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>请登录</title>
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(".form_datetime").datetimepicker({
            format: "dd MM yyyy - HH:ii P",
            showMeridian: true,
            autoclose: true,
            todayBtn: true
        });
    </script>

</head>
<body>

<div class="container">
    <div class="navigator">
        <%@ include file="headTop.jsp" %>
    </div>

    <form class="form-horizontal" role="form" method="post" action="/test/createTest">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">测试名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="请输入测试名称" name="Test.name">
            </div>
        </div>

        <div class="radio">
            <label><input type="radio" name="isExcuteNow" id="optionsRadios1" value="1" checked> 立即执行</label>
        </div>
        <div class="radio">
            <label><input type="radio" name="isExcuteNow" id="optionsRadios2" value="-1"> 定时执行</label>
        </div>

        <div class="input-append date form_datetime" data-date="2012-12-21T15:25:00Z" name="excuteTime">
            <input size="16" type="text" value="" readonly>
            <span class="add-on"><i class="icon-remove"></i></span>
            <span class="add-on"><i class="icon-th"></i></span>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">创建</button>
            </div>
        </div>
    </form>

</div>

</body>
</html>