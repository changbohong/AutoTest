<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>创建测试</title>
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- Bootstrap-datetimepicker -->
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="/js/bootstrap-datetimepicker.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="UTF-8"></script>

    <%--<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css"     rel="stylesheet">--%>
    <%--<link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">--%>

    <!-- 点击"#add",向"#target"添加内容-->
    <script>
        $(function () {
            var freq = "<div class='col-md-offset-2 col-md-9' style='padding-top:10px;'>"
                + "<input type='text' class='form-control' name='client.frequentFlyers'>"
                + "</div>";
            $("#add").click(function () {
                $("#freqs").append(freq);
            });
        });
    </script>


</head>
<body>

<div class="container">

    <form class="form-horizontal" role="form" method="post" action="/test/createTest">

        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">创建人员</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" value="${username}" name="username" readonly>
            </div>
        </div>

        <div class="form-group">
            <label for="currentTime" class="col-sm-2 control-label">当前时间</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="currentTime" value="${currentTime}" readonly>
            </div>
        </div>

        <div class="form-group">
            <label for="testname" class="col-sm-2 control-label">测试名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="testname" placeholder="请输入测试名称" value="${name}" name="name">
            </div>
        </div>

        <div class="form-group">
            <label for="optionsRadios1" class="col-sm-2 control-label">执行方案</label>
            <div class="col-sm-10">
                <div class="radio">
                    <label><input type="radio" name="isExcuteNow" id="optionsRadios1" value="true" checked> 立即执行</label>
                </div>
            </div>
            <label for="optionsRadios2" class="col-sm-2 control-label">&nbsp</label>
            <div class="col-sm-10">
                <div class="radio">
                    <label><input type="radio" name="isExcuteNow" id="optionsRadios2" value="false"> 定时执行</label>
                </div>
            </div>
        </div>

        <!--bootstrap时间控件-->
        <div class="form-group">
            <label for="form_datetime" class="col-sm-2 control-label">执行时间</label>
            <div class="col-sm-10">
                <div class="input-append date form_datetime" id="form_datetime" data-date-format="yyyy-mm-dd hh:ii">
                    <input type="text" value="" name="excuteTime" class="form-control" readonly>
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>
            </div>
        </div>

        <%--<script type="text/javascript">--%>
        <%--$(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});--%>
        <%--</script>--%>

        <!-- datetimepicker-->
        <script type="text/javascript">
            $(".form_datetime").datetimepicker({
                language: "zh-CN",
                showMeridian: true,
                autoclose: true,
                todayBtn: true
            });
        </script>

        <%--<div id="freqs" class="form-group">--%>
        <%--<label class="control-label col-md-2" for="freqs">常旅客：</label>--%>
        <%--<div class="col-md-9">--%>
        <%--<input type="text" class="form-control" name="">--%>
        <%--</div>--%>
        <%--<div class="col-md-1">--%>
        <%--<button class="btn btn-success" id="add" type="button">--%>
        <%--<span class="glyphicon glyphicon-plus"></span>--%>
        <%--</button>--%>
        <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">创建</button>
            </div>
        </div>
    </form>

    <%--<div class="control-group">--%>
    <%--<label class="control-label">DateTime Picking</label>--%>
    <%--<div class="controls input-append date form_datetime" data-date="1979-09-16T05:25:07Z"--%>
    <%--data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">--%>
    <%--<input size="16" type="text" value="" name="excuteTime" readonly>--%>
    <%--<span class="add-on"><i class="icon-remove"></i></span>--%>
    <%--<span class="add-on"><i class="icon-th"></i></span>--%>
    <%--</div>--%>
    <%--<input type="hidden" id="dtp_input1" value=""/><br/>--%>
    <%--</div>--%>


</div>


</body>
</html>