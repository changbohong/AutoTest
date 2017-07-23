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
                    <input type="text" value="" name="excuteTime" class="form-control" placeholder="点击即可输入时间" readonly>
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>
            </div>
        </div>

        <!-- datetimepicker-->
        <script type="text/javascript">
            $(".form_datetime").datetimepicker({
                language: "zh-CN",
                showMeridian: true,
                autoclose: true,
                todayBtn: true
            });
        </script>

        <!-- 点击"#add",向"#target"添加内容-->
        <script>
            $(function () {
                var testingNo = 2;
                $("#add").click(function () {
                    var testing =
                        "<hr>"
                        + "<div class='form-group'>"
                            + "<label class='col-sm-2 control-label'>测试过程编号</label>"
                            + "<div class='col-sm-10'>"
//                                + "<input type='text' class='form-control' value='"+testingNo+"' name='testingList["+(testingNo - 1)+"].id' readonly>"
                                + "<input type='text' class='form-control' value='"+testingNo+"' readonly>"
                            + "</div>"
                        + "</div>"
                        + "<div class='form-group'>"
                            + "<label class='col-sm-2 control-label'>测试过程名称</label>"
                            + "<div class='col-sm-10'>"
                                + "<input type='text' class='form-control' value='' placeholder='请输入测试过程名称' name='testingList["+(testingNo - 1)+"].testingName'>"
                            + "</div>"
                        + "</div>"
                        + "<div class='form-group'>"
                            + "<label class='col-sm-2 control-label'>测试过程URL</label>"
                            + "<div class='col-sm-10'>"
                                + "<input type='text' class='form-control' value='' placeholder='请输入测试过程URL' name='testingList["+(testingNo - 1)+"].url'>"
                            + "</div>"
                        + "</div>"
                        + "<div class='form-group'>"
                            + "<label class='col-sm-2 control-label'>测试过程输入</label>"
                            + "<div class='col-sm-10'>"
                                + "<input type='text' class='form-control' value='' placeholder='请输入测试过程输入' name='testingList["+(testingNo - 1)+"].input'>"
                            + "</div>"
                        + "</div>"
                        + "<div class='form-group'>"
                            + "<label class='col-sm-2 control-label'>测试过程预期输出</label>"
                            + "<div class='col-sm-10'>"
                                + "<input type='text' class='form-control' value='' placeholder='请输入测试过程预期输出' name='testingList["+(testingNo - 1)+"].expectOutput'>"
                            + "</div>"
                        + "</div>";





                    $("#testings").append(testing);
                    testingNo++;
                });
            });
        </script>

        <div id="testings">
            <hr>
            <div class="form-group">
                <label class="col-sm-2 control-label">测试过程编号</label>
                <div class="col-sm-10">
                    <%--<input type="text" class="form-control"  value="1" name="testingList[0].id" readonly>--%>
                    <input type="text" class="form-control"  value="1" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">测试过程名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入测试过程名称" value="" name="testingList[0].testingName">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">测试过程URL</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入测试过程URL" value="" name="testingList[0].url">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">测试过程输入</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入测试过程输入" value="" name="testingList[0].input">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">测试过程预期输出</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入测试过程输出" value="" name="testingList[0].expectOutput">
                </div>
            </div>
        </div>

        <div id="test">
            <hr>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" id="add" class="btn btn-default">
                        <span class="glyphicon glyphicon-plus"/> 添加测试过程
                    </button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-ok"/> 完成创建
                    </button>
                </div>
            </div>
        </div>
    </form>

</div>


</body>
</html>