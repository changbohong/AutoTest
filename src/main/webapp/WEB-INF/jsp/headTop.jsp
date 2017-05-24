<%--
  Created by IntelliJ IDEA.
  User: scarlett
  Date: 2017/5/21
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">AutoTest Project</a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
                    <li><a href="/test/toCreate" target="_blank"><span class="glyphicon glyphicon-plus"></span> 创建测试</a></li>
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

