<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>测试报告</title>

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

        <div class="form-group">
            <label for="url" class="col-sm-2 control-label">测试地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="url" value="${test.url}" readonly>
            </div>
        </div>

    </form>

    <form class="form-horizontal" role="form">
        <c:forEach var="testing" items="${testingList}">
            <hr>
            <div class="form-group">
                <label for="testingName" class="col-sm-2 control-label">测试单元名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="testingName" value="${testing.testingName}" readonly>
                </div>
            </div>

            <div class="form-group">
                <label for="testingUrl" class="col-sm-2 control-label">测试单元子链接</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="testingUrl" value="${testing.url}" readonly>
                </div>
            </div>

            <div class="col-sm-10 col-sm-offset-2">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th class="text-center">测试字段</th>
                        <th class="text-center">测试输入</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${testing.testingInput}">
                        <tr>
                            <td>${item.key}</td>
                            <td>${item.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th class="text-center">返回字段</th>
                        <th class="text-center">测试预期输出</th>
                        <th class="text-center">测试实际输出</th>
                        <th class="text-center">测试结果</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="testingOutputResult" items="${testing.testingOutputResultList}">
                        <tr>
                            <td>${testingOutputResult.key}</td>
                            <td>${testingOutputResult.expectedOutput}</td>
                            <td>${testingOutputResult.output}</td>
                            <td>${testingOutputResult.result}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:forEach>
    </form>


</div>


</body>
</html>