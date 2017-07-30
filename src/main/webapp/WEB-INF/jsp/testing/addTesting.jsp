<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>添加测试单元</title>
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
<div class="navigator">
    <jsp:include page="/WEB-INF/jsp/headTop.jsp"/>
</div>
<div class="container">

    <form class="form-horizontal" role="form">

        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">创建人员</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" value="${username}" readonly>
            </div>
        </div>

        <div class="form-group">
            <label for="testname" class="col-sm-2 control-label">测试名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="testname" value="${test.name}" readonly>
            </div>
        </div>

        <div class="form-group">
            <label for="createTime" class="col-sm-2 control-label">创建时间</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="createTime" value="${test.createTime}" readonly>
            </div>
        </div>

        <c:if test="${test.isExcuteNow == true}">
            <div class="form-group">
                <label for="isExcuteNow1" class="col-sm-2 control-label">执行方案</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="isExcuteNow1" value="立即执行" readonly>
                </div>
            </div>
        </c:if>

        <c:if test="${test.isExcuteNow != true}">
            <div class="form-group">
                <label for="isExcuteNow2" class="col-sm-2 control-label">执行方案</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="isExcuteNow2" value="定时执行" readonly>
                </div>
            </div>

            <div class="form-group">
                <label for="form_datetime" class="col-sm-2 control-label">执行方案</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="form_datetime" value="${test.excuteTime}" readonly>
                </div>
            </div>
        </c:if>

    </form>
    <form class="form-horizontal" role="form" method="post" action="/testing/addTesting">
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

        <div id="testing">
            <hr>
            <div class="form-group" style="display: none">
                <label for="testname" class="col-sm-2 control-label">测试Id</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="testId" value="${test.id}" name="testId" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">测试过程名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入测试过程名称" value="" name="testingName">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">测试过程URL</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入测试过程URL" value="" name="url">
                </div>
            </div>
            <div id="testingInput">
                <div class="form-group">
                    <label class="col-sm-2 control-label">输入字段</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="请输入字段，例如'username'" value=""
                               name="testingInputList[0].inputKey">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">字段值</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="请输入对应字段值，例如'changbohong'" value=""
                               name="testingInputList[0].inputValue">
                    </div>
                </div>
            </div>
            <div id="expectedTestingOutput">
                <div class="form-group">
                    <label class="col-sm-2 control-label">预期输出字段</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="请输入字段，例如'code'" value=""
                               name="expectedTestingOutputList[0].outputKey">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">字段值</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="请输入对应字段值，例如'0'" value=""
                               name="expectedTestingOutputList[0].outputValue">
                    </div>
                </div>
            </div>
        </div>

        <%--<div id="test">--%>
        <%--<hr>--%>
        <%--<div class="form-group">--%>
        <%--<div class="col-sm-offset-2 col-sm-10">--%>
        <%--<button type="button" id="add" class="btn btn-default">--%>
        <%--<span class="glyphicon glyphicon-plus"/> 添加测试过程--%>
        <%--</button>--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">
                    <span class="glyphicon glyphicon-ok"/> 完成添加
                </button>
            </div>
        </div>
</div>
</form>


</div>


</body>
</html>