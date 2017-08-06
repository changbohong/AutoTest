<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container text-center">
    <form class="form-inline" action="/test/searchTest" method="post" style="padding-top:10px;padding-bottom:10px;">
        <div class="form-group">
            <label for="name">测试名称</label>
            <input class="form-control" id="name" name="name" type="text" value="${name}">
        </div>
        <div class="form-group">
            <label for="status">测试状态：</label>
            <select class="form-control" id="status" name="status">
                <option value="">请选择</option>
                <option value="true" name="excuted">已执行</option>
                <option value="false" name="excuted">未执行</option>
            </select>
        </div>
        <button class="btn btn-default" type="submit">
            <span class="glyphicon glyphicon-search"></span> 搜索
        </button>
    </form>


    <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th class="text-center">测试编号</th>
            <th class="text-center">创建者ID</th>
            <th class="text-center">测试名称</th>
            <th class="text-center">测试状态</th>
            <th class="text-center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="test" items="${testList}">
            <tr>
                <td>${test.id}</td>
                <td>${test.userId}</td>
                <td>${test.name}</td>
                <td>${test.excuted}</td>
                <td>
                    <c:if test="${test.excuted!=true}">
                        <a href="/testing/toAddTesting?id=${test.id}" target="_blank">添加</a>
                        &nbsp;/&nbsp;<a href="/test/testDetails?id=${test.id}" target="_blank">修改</a>
                        &nbsp;/&nbsp;<a href="/test/testDetails?id=${test.id}" target="_blank">详情</a>
                        &nbsp;/&nbsp;<a href="/test/testRun?id=${test.id}" target="_blank">执行</a>
                    </c:if>
                    <c:if test="${test.excuted==true}">
                        <a href="/test/testRun?id=${test.id}" target="_blank">重新执行</a>
                        &nbsp;/&nbsp;<a href="/test/testReport?id=${test.id}" target="_blank">查看报告</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination" style="margin-top:-10px;">
        <a href="#" class="first" data-action="first">&laquo;</a>
        <a href="#" class="previous" data-action="previous">&lsaquo;</a>
        <input type="text" readonly="readonly" data-max-page=${maxPage}>
        <a href="#" class="next" data-action="next">&rsaquo;</a>
        <a href="#" class="last" data-action="last">&raquo;</a>
    </div>

    <script type="text/javascript">
        $(function () {
            // 拦截搜索动作
            $("form").submit(function () {
                var url = $(this).attr("action");
                var params = {
                    name: $("#name").val()
                };
                onsearch(url, params);

                // 阻止表单默认提交
                return false;
            });

        });
    </script>
</div>