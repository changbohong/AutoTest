<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: scarlett
  Date: 2017/5/22
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>AutoTest</title>

    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- Loading插件 -->
    <link href="/css/waitMe.min.css" rel="stylesheet">
    <script src="/js/waitMe.min.js"></script>


    <!-- jQuery分页插件 -->
    <link href="/CRM/css/jqpagination.css" rel="stylesheet" type="text/css">
    <script src="/CRM/js/jquery.jqpagination.min.js" type="text/javascript"></script>

    <!-- bootstrap样式微调-->
    <style>
        /* 将页脚固定在页面底部  */
        #main {
            padding-bottom: 40px; /* Height of the footer */
        }

        .bg-footer {
            padding-top: 10px;
            color: grey;
            background-color: #222222;/*主题色：#222222*/
        }

        footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 40px; /* Height of the footer */
        }
    </style>

    <script type="text/javascript">
        // 初始化Loading插件
        function runWaitMe(target) {
            $(target).waitMe({

                //none, rotateplane, stretch, orbit, roundBounce, win8,
                //win8_linear, ios, facebook, rotation, timer, pulse,
                //progressBar, bouncePulse or img
                effect: 'bounce',

                //place text under the effect (string).
                text: '加载中...',

                //background for container (string).
                bg: '',

                //color for background animation and text (string).
                color: '#222222',

                //change width for elem animation (string).
                sizeW: '',

                //change height for elem animation (string).
                sizeH: '',

                // url to image
                source: ''

            });
        }

        function onsearch(url, params) {
            // 显示Loading画面
            runWaitMe("#main");
            // 加载第1页到#main
            params.page = 1;
            $("#main").load(url, params, function() {
                // 隐藏Loading
                $("#main").waitMe("hide");
                // 初始化分页插件
                $(".pagination").jqPagination({
                    page_string : "第 {current_page} / {max_page} 页",
                    // 点击翻页按钮回调
                    paged : function(page) {
                        // 显示Loading画面
                        runWaitMe();
                        // 刷新table load表示刷新局部
                        params.page = page;
                        $("table").load(url + " thead,tbody", params, function() {
                            // 隐藏Loading
                            $("#main").waitMe("hide");
                        });
                    }
                });
            });
        }

        // 为导航按钮绑定点击事件
        $(function () {
            $("#nav a").each(function () {
                var url = $(this).attr("href");
                $(this).click(function () {
                    onsearch(url, {});

                    $(this).parent("li").addClass("active") // 父li元素添加active属性
                        .siblings("li").removeClass("active"); // 父li元素同级的li元素移除active属性

                    // 阻止a标签的默认动作
                    return false;
                });
            });
        });

        // 模拟点击导航按钮
        $(function () {
            var url = $("#nav li.active a").attr("href");

            onsearch(url, {});
        });
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">AutoTest Project</a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav" id="nav">
                    <li class="active"><a href="/test/searchTest"><span class="glyphicon glyphicon-home"></span>
                        主页</a></li>
                    <li><a href="/test/toCreate" target="_blank"><span class="glyphicon glyphicon-plus"></span> 创建测试</a>
                    </li>
                    <li><a href="#support"><span class="glyphicon glyphicon-headphones"></span> Support</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"/>${username} <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#" target="_blank">jmeter</a></li>
                            <li><a href="#">EJB</a></li>
                            <li><a href="#">Jasper Report</a></li>
                            <li class="divider"></li>
                            <li><a href="#">分离的链接</a></li>
                            <li class="divider"></li>
                            <li><a href="#">另一个分离的链接</a></li>
                        </ul>
                    </li>
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> 登出</a></li>
                </ul>
            </div><!-- /.nav-collapse -->
        </div><!-- /.container -->
    </div>
</nav>
<c:if test="${msg!=null}">
<div class="alert alert-success alert-dismissable">
    <button type="button" class="close" data-dismiss="alert"
            aria-hidden="true">
        &times;
    </button>
    ${msg}
</div>
</c:if>

<div id="main"></div>

<footer class="container-fluid bg-footer text-center">
    <p>
        Copyright &copy; 2018 <a href="#">edu.bupt.com</a>
    </p>
</footer>
</body>
</html>
